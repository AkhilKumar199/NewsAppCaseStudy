package com.cg.service;

import java.util.List;

import com.cg.exception.LifeStyleAlreadyExists;
import com.cg.exception.LifeStyleIdNotFound;
import com.cg.model.LifeStyle;



public interface LifeStyleService {
	public LifeStyle addLifeStyle(LifeStyle lifestyle)throws LifeStyleAlreadyExists;
	public List<LifeStyle> getAllLifeStyles();
	public void deleteLifeStyleByid(String id)throws LifeStyleIdNotFound;
	LifeStyle updateLifeStyle(LifeStyle lifestyle,String id)throws LifeStyleIdNotFound;
	
	

}