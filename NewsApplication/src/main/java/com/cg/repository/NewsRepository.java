// Importing package in this code module
package com.cg.repository;
//Importing required classes
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.News;


//Interface
public interface NewsRepository extends MongoRepository<News,Integer>{

}
