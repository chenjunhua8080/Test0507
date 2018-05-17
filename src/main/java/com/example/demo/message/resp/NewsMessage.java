package com.example.demo.message.resp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table
public class NewsMessage extends Message{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

//	@OneToMany(cascade=CascadeType.ALL)
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
