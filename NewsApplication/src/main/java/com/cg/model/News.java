package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="news")
public class News {
	//Attributes
	@Id //Primary Key
	public int newsId;
	public String newsTitle;
	public String newsPublisher;
	public String newsRating;
	
	//Default Constructor
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor
	
	public News(int newsId, String newsTitle, String newsPublisher, String newsRating) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsPublisher = newsPublisher;
		this.newsRating = newsRating;
	}
	
	//getters and setters
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsPublisher() {
		return newsPublisher;
	}
	public void setNewsPublisher(String newsPublisher) {
		this.newsPublisher = newsPublisher;
	}
	public String getNewsRating() {
		return newsRating;
	}
	public void setNewsRating(String newsRating) {
		this.newsRating = newsRating;
	}
	
	//toString method
	
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsPublisher=" + newsPublisher
				+ ", newsRating=" + newsRating + "]";
	}
	
}