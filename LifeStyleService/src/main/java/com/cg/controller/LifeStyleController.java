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


import com.cg.exception.LifeStyleAlreadyExists;

import com.cg.model.LifeStyle;
import com.cg.repository.LifeStyleRepository;

import com.cg.service.LifeStyleService;



@RestController
@RequestMapping("/api/v1")
public class LifeStyleController {

    @Autowired
    private LifeStyleRepository lifestylerepository;
    
    @Autowired
    private LifeStyleService lifestyleServ;
 
    @PostMapping("/addlifestyle")
    public ResponseEntity<LifeStyle>addLifeStyle(@RequestBody LifeStyle lifestyle) throws LifeStyleAlreadyExists {
    	LifeStyle savedlifestyle = lifestyleServ.addLifeStyle(lifestyle);
        return new ResponseEntity<>(savedlifestyle, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Optional<LifeStyle> getLifeStyle(@PathVariable String id){
        return lifestylerepository.findById(id);
    }
    @GetMapping("/findallLifeStyles")
    public List<LifeStyle> getLifeStyles(){
        return lifestylerepository.findAll();

    }
    @PutMapping("/update/{id}")
    public LifeStyle updateLifeStyle(@PathVariable("id") String id,@RequestBody LifeStyle lifestyle ) {
    	lifestyle.setId(id);
    	lifestylerepository.save(lifestyle);
        return lifestyle;
    }

     @DeleteMapping("/del/{id}")
     public String deleteArticle (@PathVariable String id) {
    	 lifestylerepository.deleteById(id);
        return "Article deleted with id : "+id;
        }
    }