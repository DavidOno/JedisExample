package de.db.praktikum4;


import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final RedisDB db = RedisDBImpl.getInstance();
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	private static String ethernetID;
	private static String ermID;
	private static String gotoID;
	private static String unixID;
	private static String osiID;
	private static String shareddbID;
	private static String cspID;
	private static String cryptoID;
	
	private static final String RATER1 = "rater1";
	private static final String RATER2 = "rater2";
	private static final String RATER3 = "rater3";
	private static final String RATER4 = "rater4";

	public static void main(String[] args) {
		BasicConfigurator.configure();
		log.info("{}", "Posting several articles");
		postArticles();
		log.info("{}", "Retrieving articles:");
		retrieveArticles();
		log.info("{}", "Rating articles:");
		rateArticles();
		log.info("{}", "Get the n-best articles:");
		getNBestArticles();
		log.info("{}", "Continue rating articles:");
		rateArticlesContinued();
		log.info("{}", "Get the n-best articles again. Now CRYPTO should be at first place:");
		getNBestArticles();
	}

	private static void rateArticlesContinued() {
		log.info("Rater4 rates CRYPTO with 1.0. In Total {}", db.rateArticle(cryptoID, RATER4, 1.0));
	}

	private static void getNBestArticles() {
		log.info("N = 1: \n{}", db.getNBestArticles(1));
		log.info("N = 2: \n{}", db.getNBestArticles(2));
		log.info("N = 3: \n{}", db.getNBestArticles(3));
		log.info("N = 4 (only 3 articles in total are rated): \n{}", db.getNBestArticles(4));
	}

	private static void rateArticles() {
		//best rating:
		rateEthernetArticle();
		//second-best rating:
		rateCryptoArticle();
		//worst rating
		rateCSPArticle();
	}

	private static void rateCSPArticle() {
		log.info("Rater1 rates CSP with 3.0. In Total {}", db.rateArticle(cspID, RATER1, 3.0));
		log.info("Rater2 rates CSP with 4.5. In Total {}", db.rateArticle(cspID, RATER2, 4.5));
		log.info("Rater3 rates CSP with 3.6. In Total {}", db.rateArticle(cspID, RATER3, 3.6));
	}

	private static void rateCryptoArticle() {
		log.info("Rater1 rates CRYPTO with 2.0. In Total {}", db.rateArticle(cryptoID, RATER1, 2.0));
		log.info("Rater2 rates CRYPTO with 3.5. In Total {}", db.rateArticle(cryptoID, RATER2, 3.5));
		log.info("Rater3 rates CRYPTO with 2.6. In Total {}", db.rateArticle(cryptoID, RATER3, 2.6));
	}

	private static void rateEthernetArticle() {
		log.info("Rater1 rates Ethernet with 1.2. In Total {}", db.rateArticle(ethernetID, RATER1, 1.2));
		log.info("Rater1 rates Ethernet a second time with 2.0. Duplicate detection: {}", db.rateArticle(ethernetID, RATER1, 2.0));
		log.info("Rater2 rates Ethernet with 3.5. In Total {}", db.rateArticle(ethernetID, RATER2, 3.5));
		log.info("Rater3 rates Ethernet with 2.6. In Total {}", db.rateArticle(ethernetID, RATER3, 2.6));
	}

	private static void retrieveArticles() {
		log.info("{}", db.getArticleInfo(ethernetID));
		log.info("{}", db.getArticleInfo(ermID));
		log.info("{}", db.getArticleInfo(gotoID));
		log.info("{}", db.getArticleInfo(unixID));
		log.info("{}",  db.getArticleInfo(osiID));
		log.info("{}", db.getArticleInfo(shareddbID));
		log.info("{}", db.getArticleInfo(cspID));
		log.info("{}", db.getArticleInfo(cryptoID));
	}

	private static void postArticles() {
		ethernetID = db.postArticle("Ethernet", "Metcalfe/Bloggs");
		ermID = db.postArticle("The Entity Relationship Model", "Chen");
		gotoID = db.postArticle("Go To Statement Considered Harmful", "Dijkstra");
		unixID = db.postArticle("UNIX Time Sharing System", "Ritchie/Thompson");
		osiID = db.postArticle("OSI Reference Model", "Zimmerman");
		shareddbID = db.postArticle("A Relational Model of Datafor Large Shared Data Banks", "Codd");
		cspID = db.postArticle("Communicating Sequential Processes", "Hoare");
		cryptoID = db.postArticle("New Directions in Cryptography", "Diffie/Hellman");
	}

}
