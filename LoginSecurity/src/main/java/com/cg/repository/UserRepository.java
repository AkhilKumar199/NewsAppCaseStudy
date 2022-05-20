package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.UserModel;
//Annotation
@Repository
//Interface
public interface UserRepository extends MongoRepository<UserModel, String>{
	
	UserModel findByUsername(String username);

}
