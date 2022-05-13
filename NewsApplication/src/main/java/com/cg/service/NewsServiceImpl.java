// Importing package module to code fragment
package com.cg.service;

//Importing required classes
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.NewsAlreadyExists;
import com.cg.exception.NewsIdNotFound;
import com.cg.model.News;
import com.cg.repository.NewsRepository;

 
//Annotation
@Service

//Class
public  class NewsServiceImpl implements NewsService{

    private NewsRepository newsRepo;
 
    @Autowired
    public NewsServiceImpl(NewsRepository newsRepo) {
        super();
        this.newsRepo = newsRepo;
    }
 
    @Override
    public News addNews(News news) throws NewsAlreadyExists {
        // TODO Auto-generated method stub
        if(newsRepo.existsById(news.getNewsId())) {
            throw new NewsAlreadyExists();
        }
    	News savedNews= newsRepo.save(news);
        return savedNews;
    }
    
 // Read operation
 
    @Override
    public List<News> getAllNews()  {
        // TODO Auto-generated method stub

        return (List<News>) newsRepo.findAll();
 
    }
    
 // Update operation
 
    @Override
    public News updateNews(News news, int newsId) throws NewsIdNotFound {
        // TODO Auto-generated method stub


        Optional<News> newsDB =this.newsRepo.findById(news.getNewsId());
        if(newsDB.isPresent()) {
        	News newsUpdate = newsDB.get();
        	newsUpdate.setNewsId(news.getNewsId());
        	newsUpdate.setNewsTitle(news.getNewsTitle());
        	newsUpdate.setNewsPublisher(news.getNewsPublisher());
        	newsUpdate.setNewsRating(news.getNewsRating());
        	newsRepo.save(news);
        return news;
    }
        else
        {
        throw new NewsIdNotFound(); 
        }
    }
    
    // Delete operation
 
    @Override
    public void deleteNewsBynewsId(int newsId) throws NewsIdNotFound{
        // TODO Auto-generated method stub
    Optional<News> newsDB = this.newsRepo.findById(newsId);
        if(newsDB.isPresent()) { 
            this.newsRepo.delete(newsDB.get());
        }
        else
        {
            throw new NewsIdNotFound();

        }
 
    }
 
}