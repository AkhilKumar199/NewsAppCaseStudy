package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.LifeStyle;



public interface LifeStyleRepository extends MongoRepository<LifeStyle, String>{

}