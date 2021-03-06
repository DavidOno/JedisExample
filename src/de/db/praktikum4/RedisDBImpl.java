package de.db.praktikum4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class RedisDBImpl implements RedisDB {
	
	private static final Logger log = LoggerFactory.getLogger(RedisDBImpl.class);
	
	private static final String RATING = "Rating";
	private static final String RATERSET_FLAG = "-raterset";
	private static final String TITLE = "Titel";
	private static final String AUTHOR = "Author";
	
	private static RedisDB instance;
	private Jedis jedis;
	
	private RedisDBImpl() {
		jedis = new Jedis();
	}

	@Override
	public String postArticle(String title, String author) {
		String articleUID = generateUID();
		Map<String, String> values = buildValueMap(title, author);
		jedis.hmset(articleUID, values);
		return articleUID;
	}

	private Map<String, String> buildValueMap(String title, String author) {
		Map<String, String> values = new HashMap<>();
		values.put(AUTHOR, author);
		values.put(TITLE, title);
		return values;
	}

	private String generateUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public double rateArticle(String articleId, String raterId, double rating) {
		String raterSetUID = getRaterSetUIDForArticle(articleId);
		long result = jedis.sadd(raterSetUID, raterId);
		double updatedScore = -1;
		if(wasAddSuccessfull(result)) {
			updatedScore = updateScore(articleId, rating, raterSetUID);
		}
		return updatedScore;
	}

	private double updateScore(String articleId, double rating, String raterSetUID) {
		double updatedScore = calculateUpdatedScore(articleId, rating, raterSetUID);
		addUpdatedScoreToDB(articleId, updatedScore);
		return updatedScore;
	}

	private void addUpdatedScoreToDB(String articleId, double updatedScore) {
		Map<String, Double> score = new HashMap<>();
		score.put(articleId, updatedScore);
		jedis.zadd(RATING, score);
	}

	private String getRaterSetUIDForArticle(String articleId) {
		return articleId+RATERSET_FLAG;
	}

	private double calculateUpdatedScore(String articleId, double rating, String raterSetUID) {
		double currentRatingScore = getCurrentScore(articleId);
		long numberOfRater = jedis.scard(raterSetUID);
		return (Math.max(numberOfRater - 1, 0) * currentRatingScore + rating) / (numberOfRater);
	}

	private double getCurrentScore(String articleId) {
		Double currentScore = jedis.zscore(RATING, articleId);
		if(currentScore == null)
			return 0;
		return currentScore.doubleValue();
	}

	private boolean wasAddSuccessfull(long result) {
		return result == 1;
	}

	@Override
	public ArticleInfo getArticleInfo(String articleId) {
		Map<String, String> result = jedis.hgetAll(articleId);
		List<String> values = new ArrayList<>(result.values());
		return new ArticleInfo(values.get(0), values.get(1));
	}

	@Override
	public List<ArticleInfo> getNBestArticles(int n) {
		Set<String> allArticles = jedis.zrevrange(RATING, 0, -1);
		List<String> allArticlesAsList = new ArrayList<>(allArticles);
		Collections.reverse(allArticlesAsList);
		return getNBest(n, allArticlesAsList);
	}

	private List<ArticleInfo> getNBest(int n, List<String> allArticles) {
		return allArticles.stream()
					.limit(Math.min(allArticles.size(), n))
					.map(this::getArticleInfo)
					.collect(Collectors.toList());
	}

	public static RedisDB getInstance() {
		if(instance == null) {
			instance = new RedisDBImpl();
		}
		log.info("{}", "Instantiated Redis-Database-Client");
		return instance;
	}
}
