package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.exception.TechnologyAlreadyExists;
import com.cg.exception.TechnologyIdNotFound;
import com.cg.model.Technology;
import com.cg.repository.TechnologyRepository;

import com.cg.service.TechnologyService;

//Annotation

@RestController
@RequestMapping("/api/v1")

//Main class

public class TechnologyController {

    @Autowired
    private TechnologyRepository technologyrepository;
    
    
    @Autowired
    private TechnologyService technologyServ;
 
    
    // Save operation
    @PostMapping("/addtechnology")
    public ResponseEntity<Technology>addTechnology(@RequestBody Technology technology) throws TechnologyAlreadyExists {
    	Technology savedarticle = technologyServ.addTechnology(technology);
        return new ResponseEntity<>(savedarticle, HttpStatus.CREATED);
    }
    
    // Read operation
    
    @GetMapping("/{id}")
    public Optional<Technology> getTechnology(@PathVariable String id){
        return technologyrepository.findById(id);
    }
    
    // Read operation
    
    @GetMapping("/findalltechnology")
    public List<Technology> getLifeStyles(){
        return technologyrepository.findAll();

    }
    
    // Update operation
    
    @PutMapping("/update/{id}")
    public Technology updateTechnology(@PathVariable("id") String id,@RequestBody Technology technology ) throws TechnologyIdNotFound {
    	technology.setId(id);
    	technologyrepository.save(technology);
        return technology;
    }
    
    
    // Delete operation

     @DeleteMapping("/del/{id}")
     public String deleteArticle (@PathVariable String id) throws TechnologyIdNotFound {
    	 technologyrepository.deleteById(id);
        return "Technology deleted with id : "+id;
        }
    }