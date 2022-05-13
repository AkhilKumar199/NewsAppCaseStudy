package com.cg.service;

import java.util.List;

import com.cg.exception.NewsAlreadyExists;
import com.cg.exception.NewsIdNotFound;
import com.cg.model.News;

public interface NewsService {
	public News addNews(News news)throws NewsAlreadyExists;
	public List<News> getAllNews();
	public void deleteNewsBynewsId(int newsId)throws NewsIdNotFound;
	News updateNews(News news,int newsId)throws NewsIdNotFound;
	
	

}
