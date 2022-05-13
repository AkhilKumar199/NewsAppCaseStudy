package com.cg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TechnologyModelTest {
	
private Technology t;
	
	@BeforeEach
	public void preConfig() {
		
		t = new Technology();		
		t.setId("1");
		t.setTitle("testTitle");
		t.setDescription("test description");
		;
}
	@Test
	public void FavTest() {
		Technology a = Mockito.mock(Technology.class);
		assertNotNull(a);
	}
	
	@Test
	public void FavModelTestSuccess() {
		assertEquals(t.getId(),"1");
		assertEquals(t.getTitle(),"testTitle");
		assertEquals(t.getDescription(),"test description");
		
		
	}
	@Test
	public void FavModelTestFailure() {
		assertNotEquals(t.getId(),"");
		assertNotEquals(t.getTitle(),"");
		assertNotEquals(t.getDescription(),"");

		
	}

}