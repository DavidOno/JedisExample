package de.db.praktikum4;

public class ArticleInfo {
	
	private String author;
	private String title;
	
	
	public ArticleInfo(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "ArticleInfo [author=" + author + ", title=" + title + "]";
	}

}
