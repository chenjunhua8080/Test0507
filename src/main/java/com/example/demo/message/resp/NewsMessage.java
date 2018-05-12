package com.example.demo.message.resp;

import java.util.List;

public class NewsMessage extends Message{
	
	private List<NewsItem> Articles;
	private int ArticleCount;
	public NewsMessage() {
	}
	public List<NewsItem> getArticles() {
		return Articles;
	}
	public void setArticles(List<NewsItem> articles) {
		Articles = articles;
	}
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public NewsMessage(String toUserName, String fromUserName, Integer createTime, String msgType,
			List<NewsItem> articles, int articleCount) {
		super(toUserName, fromUserName, createTime, msgType);
		Articles = articles;
		ArticleCount = articleCount;
	}


	

}
