package com.cg.service;

import java.util.List;

import com.cg.exception.TechnologyAlreadyExists;
import com.cg.exception.TechnologyIdNotFound;
import com.cg.model.Technology;



public interface TechnologyService {
	public Technology addTechnology(Technology technology)throws TechnologyAlreadyExists;
	public List<Technology> getAllTechnology();
	public void deleteNewsByid(String id)throws TechnologyIdNotFound;
	Technology updateTechnology(Technology news,String id)throws TechnologyIdNotFound;
	
	

}
