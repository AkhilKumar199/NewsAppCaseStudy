package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.News;
import com.cg.service.NewsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class NewsControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	
	@Mock
	private NewsService ns;
	private News n;
	private List<News> newsList;
	
	@InjectMocks
	private NewsController nc;
	
	@BeforeEach
	public void setUp() {
		n = new News(1,"MadMax","mak","5Star Rating");
		mocMvc = MockMvcBuilders.standaloneSetup(nc).build();
		
	}
	

	@Test
	public void ChannelControllerTest() throws Exception{
	when(ns.addNews(any())).thenReturn(n);
	mocMvc.perform(post("/api/v1/news")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(n)))
	.andExpect(status().isCreated());
	verify(ns,times(1)).addNews(any());


	}



	@Test
	public void getAllNewsControllerTest() throws Exception {
	when(ns.getAllNews()).thenReturn(newsList);
	mocMvc.perform(MockMvcRequestBuilders.get("/api/v1/News")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(n)))
	.andDo(MockMvcResultHandlers.print());
	verify(ns,times(1)).getAllNews();


	}


	public static String asJSONString(final Object obj) {
	// TODO Auto-generated method stub
	try {

	return new ObjectMapper().writeValueAsString(obj);
	} catch (Exception e) {
	throw new RuntimeException(e);
	}
	}







	}
