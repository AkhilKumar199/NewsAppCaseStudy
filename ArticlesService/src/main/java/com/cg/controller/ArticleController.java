// Importing package in this code module
package com.cg.controller;
//Importing required classes
import java.util.List;
import java.util.Optional;

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

import com.cg.exception.ArticleAlreadyExists;
import com.cg.exception.ArticleIdNotFound;

import com.cg.model.Article;

import com.cg.repository.ArticleRepository;
import com.cg.service.ArticleService;

 //Annotation
@RestController
@RequestMapping("/api/v1")
public class ArticleController {
 
  //Annotation
    @Autowired
    private ArticleRepository articlerepository;
  //Annotation
    @Autowired
    private ArticleService articleServ;
 
 // Save operation
    @PostMapping("/addArticle")
    public ResponseEntity<Article>addArticle(@RequestBody Article article) throws ArticleAlreadyExists {
    	Article savedarticle = articleServ.addArticle(article);
        return new ResponseEntity<>(savedarticle, HttpStatus.CREATED);
    }
 
 // Read operation
    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable String id){
        return articlerepository.findById(id);
    }
    @GetMapping("/findallArticles")
    public List<Article> getArticles(){
        return articlerepository.findAll();

    }
 
  // Update operation
    @PutMapping("/update/{id}")
    public Article updateArticle(@PathVariable("id") String id,@RequestBody Article article ) throws ArticleIdNotFound {
    	article.setId(id);
        articlerepository.save(article);
        return article;
    }
 
// Delete operation
     @DeleteMapping("/del/{id}")
     public String deleteArticle (@PathVariable String id) throws ArticleIdNotFound {
    	 articlerepository.deleteById(id);
        return "Article deleted with id : "+id;
        }
    }
