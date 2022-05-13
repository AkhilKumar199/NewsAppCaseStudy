package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Article;

public interface ArticleRepository extends MongoRepository<Article, String>{

}
