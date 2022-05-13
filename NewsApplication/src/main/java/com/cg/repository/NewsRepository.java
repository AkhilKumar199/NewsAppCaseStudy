package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.News;


//Interface
public interface NewsRepository extends MongoRepository<News,Integer>{

}
