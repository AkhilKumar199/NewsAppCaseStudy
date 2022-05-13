package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Technology;

//Interface

public interface TechnologyRepository extends MongoRepository<Technology, String>{

}