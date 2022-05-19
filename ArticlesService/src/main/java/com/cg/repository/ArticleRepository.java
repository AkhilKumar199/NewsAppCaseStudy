// Importing package in this code module
package com.cg.repository;
//Importing required classes
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Article;

//Interface
public interface ArticleRepository extends MongoRepository<Article, String>{

}
