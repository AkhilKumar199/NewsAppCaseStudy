package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.LifeStyleAlreadyExists;
import com.cg.exception.LifeStyleIdNotFound;
import com.cg.model.LifeStyle;
import com.cg.repository.LifeStyleRepository;



//Annotation
@Service

//Class
public  class LifeStyleServiceImpl implements LifeStyleService{

private LifeStyleRepository lifestyleRepo;

@Autowired
public LifeStyleServiceImpl(LifeStyleRepository lifestyleRepo) {
    super();
    this.lifestyleRepo = lifestyleRepo;
}

@Override
public LifeStyle addLifeStyle(LifeStyle lifestyle) throws LifeStyleAlreadyExists {
    // TODO Auto-generated method stub
    if(lifestyleRepo.existsById(lifestyle.getId())) {
        throw new LifeStyleAlreadyExists();
    }
    LifeStyle savedLifeStyle= lifestyleRepo.save(lifestyle);
    return savedLifeStyle;
}

//Read operation

@Override
public List<LifeStyle> getAllLifeStyles()  {
    // TODO Auto-generated method stub

    return (List<LifeStyle>) lifestyleRepo.findAll();

}

//Update operation

@Override
public LifeStyle updateLifeStyle(LifeStyle lifestyle, String id) throws LifeStyleIdNotFound {
    // TODO Auto-generated method stub


    Optional<LifeStyle> newsDB =this.lifestyleRepo.findById(lifestyle.getId());
    if(newsDB.isPresent()) {
    	LifeStyle lifestyleUpdate = newsDB.get();
    	lifestyleUpdate.setId(lifestyle.getId());
    	lifestyleUpdate.setCategory(lifestyle.getCategory());
  	  lifestyleUpdate.setName(lifestyle.getName());
  	lifestyleRepo.save(lifestyle);
    return lifestyle;
}
    else
    {
    throw new LifeStyleIdNotFound(); 
    }
}

// Delete operation

@Override
public void deleteLifeStyleByid(String id) throws LifeStyleIdNotFound{
    // TODO Auto-generated method stub
Optional<LifeStyle> newsDB = this.lifestyleRepo.findById(id);
    if(newsDB.isPresent()) { 
        this.lifestyleRepo.delete(newsDB.get());
    }
    else
    {
        throw new LifeStyleIdNotFound();

    }

}

}