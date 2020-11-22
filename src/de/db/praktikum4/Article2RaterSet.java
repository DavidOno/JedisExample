package de.db.praktikum4;

public class Article2RaterSet {

	private String articleUID;
	private String ratingUID;
	
	public Article2RaterSet(String articleUID, String ratingUID) {
		super();
		this.articleUID = articleUID;
		this.ratingUID = ratingUID;
	}
	
	public boolean isArticleContained(String articleUID) {
		return this.articleUID == articleUID;
	}
	
	public String getRaterUID() {
		return ratingUID;
	}
	
	
}
