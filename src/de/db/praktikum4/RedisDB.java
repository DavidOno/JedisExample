package de.db.praktikum4;

import java.util.List;

public interface RedisDB {
	
	String postArticle(String title, String author);
	double rateArticle(String articleId, String raterId, double rating);
	ArticleInfo getArticleInfo(String articleId);
	List<ArticleInfo> getNBestArticles(int n);

}
