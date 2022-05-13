package com.cg.service;

//Importing required classes
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.TechnologyAlreadyExists;
import com.cg.exception.TechnologyIdNotFound;
import com.cg.model.Technology;
import com.cg.repository.TechnologyRepository;




//Annotation
@Service

//Class
public  class TechnologyServiceImpl implements TechnologyService{

  private TechnologyRepository technologyRepo;

  @Autowired
  public TechnologyServiceImpl(TechnologyRepository newsRepo) {
      super();
      this.technologyRepo = newsRepo;
  }

  @Override
  public Technology addTechnology(Technology technology) throws TechnologyAlreadyExists {
      if(technologyRepo.existsById(technology.getId())) {
    	  
          throw new TechnologyAlreadyExists();
          
      }
      Technology savedTechnology= technologyRepo.save(technology);
      return savedTechnology;
  }
  
// Read operation

  @Override
  public List<Technology> getAllTechnology()  {
     

      return (List<Technology>) technologyRepo.findAll();

  }
  
// Update operation

  @Override
  public Technology updateTechnology(Technology technology, String id) throws TechnologyIdNotFound {
     


      Optional<Technology> newsDB =this.technologyRepo.findById(technology.getId());
      if(newsDB.isPresent()) {
    	  
    	  Technology technologyUpdate = newsDB.get();
    	  technologyUpdate.setId(technology.getId());
    	  technologyUpdate.setTitle(technology.getTitle());
    	  technologyUpdate.setDescription(technology.getDescription());
    	  technologyRepo.save(technology);
      return technology;
  }
      else
      {
    	  
      throw new TechnologyIdNotFound(); 
      
      }
  }
  
  // Delete operation

  @Override
  public void deleteNewsByid(String id) throws TechnologyIdNotFound{
      
  Optional<Technology> newsDB = this.technologyRepo.findById(id);
      if(newsDB.isPresent()) { 
    	  
          this.technologyRepo.delete(newsDB.get());
      }
      
      else
      {
          throw new TechnologyIdNotFound();

      }

  }

}