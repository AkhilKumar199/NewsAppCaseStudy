package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.NewsAlreadyExists;
import com.cg.model.News;
import com.cg.repository.NewsRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NewsServiceTest {
	
	@Mock
	private NewsRepository nr;
	
	@InjectMocks
	private NewsServiceImpl nsl;
	
	

	@Test
	public void TestAddnews() throws NewsAlreadyExists{
		News n1 = new News(10,"SonyTen2","wweRaw","NXT");//User Input
		when(nr.save(any())).thenReturn(n1);
		nsl.addNews(n1);
		verify(nr,times(1)).save(any());
		
		
	}
	
	@Test
	public void testgetAllNews() {
		News n1 = new News(1,"Sony","wweRaw","NXT");//User Input
		News n2 = new News(4,"SonyTen1","wweRaw","repeat");//User Input
		News n3 = new News(6,"SonyTen2","wweRaw","SmackDown");//User Input
		nr.save(n1);
		nr.save(n2);
		nr.save(n3);
		List<News>nList = new ArrayList<>(); // Creating list Object
		nList.add(n1);
		nList.add(n2);
		nList.add(n3);
		
		when(nr.findAll()).thenReturn(nList);
		List<News> nList1 = nsl.getAllNews();
		assertEquals(nList,nList1);
		verify(nr,times(1)).save(n1);
		verify(nr,times(1)).findAll();
		
		
		
	}
	

}