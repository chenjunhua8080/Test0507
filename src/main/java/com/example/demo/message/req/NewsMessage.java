package com.example.demo.message.req;

public class NewsMessage {
	
	private String Url;
	private String PicUrl;
	private String Title;
	private String Description;
	private String Articles;
	private String ArticleCount;
	public NewsMessage() {
	}
	public NewsMessage(String url, String picUrl, String title, String description, String articles,
			String articleCount) {
		Url = url;
		PicUrl = picUrl;
		Title = title;
		Description = description;
		Articles = articles;
		ArticleCount = articleCount;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getArticles() {
		return Articles;
	}
	public void setArticles(String articles) {
		Articles = articles;
	}
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	
	

}
