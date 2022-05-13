package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.News;



@SpringBootTest
@ExtendWith(SpringExtension.class)
public class NewsRepositoryTest {
	
	@Autowired
	private NewsRepository newsRepo;
	

	@Test
	public void givenNewsshouldReturnNewsObject() {
		News n1 = new News(1,"Raw","Sony","Top Rating");//User Input
		newsRepo.save(n1);//Data is saved into Database
		News n2 =newsRepo.findById(n1.getNewsId()).get();
		assertNotNull(n2);//To check if it is returning channel Object
		assertEquals(n1.getNewsTitle(),n2.getNewsTitle());
		
	}
	@Test
	public void getAllmustReturnAllChannels() {
		News n3 = new News(4,"Entertainment","The Hindu","Low Rating");//User Input
		News n4 = new News(6,"Entertainment","TopNews","High");//User Input
		newsRepo.save(n3);//saving the info to Database
		newsRepo.save(n4);//data saved in database
		List<News>newsList = (List<News>)newsRepo.findAll();
		//assertEquals("Entertainment",newsList.get(1).getNewsTitle());
		//assertEquals(14,newsList.size());
	}

}