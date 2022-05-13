package com.cg.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ArticlesModelTest {
	
private Article f;
	
	@BeforeEach
	public void preConfig() {
		
		f = new Article();		
		f.setId("1");
		f.setName("testName");
		f.setAuthor("testAuthor");
		f.setTitle("testTitle");
		f.setDescription("test description");
		;
}
	@Test
	public void FavTest() {
		Article a = Mockito.mock(Article.class);
		assertNotNull(a);
	}
	
	@Test
	public void FavModelTestSuccess() {
		assertEquals(f.getId(),"1");
		assertEquals(f.getName(),"testName");
		assertEquals(f.getAuthor(),"testAuthor");
		assertEquals(f.getTitle(),"testTitle");
		assertEquals(f.getDescription(),"test description");
		
		
	}
	@Test
	public void FavModelTestFailure() {
		assertNotEquals(f.getId(),"");
		assertNotEquals(f.getName(),"");
		assertNotEquals(f.getAuthor(),"");
		assertNotEquals(f.getTitle(),"");
		assertNotEquals(f.getDescription(),"");

		
	}

}