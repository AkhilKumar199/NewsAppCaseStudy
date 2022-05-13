package com.cg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class NewsModelTest {
	
private News n;
	
	@BeforeEach
	public void preConfig() {
		
		n = new News();		
		n.setNewsId(1);
		n.setNewsTitle("testTitle");
		n.setNewsPublisher("test publisher");
		n.setNewsRating("testRating");
		;
}
	@Test
	public void FavTest() {
		News a = Mockito.mock(News.class);
		assertNotNull(a);
	}
	
	@Test
	public void FavModelTestSuccess() {
		assertEquals(n.getNewsId(),1);
		assertEquals(n.getNewsTitle(),"testTitle");
		assertEquals(n.getNewsPublisher(),"test publisher");
		assertEquals(n.getNewsRating(),"testRating");
		
		
	}
	@Test
	public void FavModelTestFailure() {
		assertNotEquals(n.getNewsId(),"");
		assertNotEquals(n.getNewsTitle(),"");
		assertNotEquals(n.getNewsPublisher(),"");
		assertEquals(n.getNewsRating(),"testRating");

		
	}

}