// Importing package in this code module
package com.cg.controller;
//Importing required classes
import java.util.List;
 
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.NewsAlreadyExists;
import com.cg.exception.NewsIdNotFound;
import com.cg.model.News;

import com.cg.service.NewsService;
 

    
//Annotation 
@RestController
@RequestMapping("/api/v1")
//Main class
public class NewsController {


    @Autowired
    private NewsService newsServ;
 
        

 // Save operation
    @PostMapping("/news")
    public ResponseEntity<News>addArticle(@RequestBody News news) throws NewsAlreadyExists {
    	News savedarticle = newsServ.addNews(news);
        return new ResponseEntity<>(savedarticle, HttpStatus.CREATED);

    }

 // Read operation
    @GetMapping("/News")
    public ResponseEntity<List<News>> getAllNews() {
        return new ResponseEntity<List<News>>((List<News>)newsServ.getAllNews(),HttpStatus.OK);

    }
    
 // Update operation

    @PutMapping("/news/{newsId}")
    public News 
    updateNews(@RequestBody News news, @PathVariable("newsId") int newsId) throws NewsIdNotFound {
        return newsServ.updateNews(news,newsId);
    }
    
 // Delete operation

    @DeleteMapping("/news/{newsId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable int newsId) throws NewsIdNotFound   {
    	newsServ.deleteNewsBynewsId(newsId);
        return ResponseEntity.noContent().build();
    }
 
}