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

import com.cg.exception.LifeStyleAlreadyExists;
import com.cg.model.LifeStyle;
import com.cg.repository.LifeStyleRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LifeStyleServiceTest {
	
	@Mock
	private LifeStyleRepository lr;
	
	@InjectMocks
	private LifeStyleServiceImpl lsl;
	
	

	@Test
	public void TestAddlifestyle() throws LifeStyleAlreadyExists{
		LifeStyle n1 = new LifeStyle("Sony120","wweRaw","NXT");//User Input
		when(lr.save(any())).thenReturn(n1);
		lsl.addLifeStyle(n1);
		verify(lr,times(1)).save(any());
		
		
	}
	
	@Test
	public void testgetAllNews() {
		LifeStyle l1 = new LifeStyle("Sony","wweRaw","NXT");//User Input
		LifeStyle l2 = new LifeStyle("SonyTen1","wweRaw","repeat");//User Input
		LifeStyle l3 = new LifeStyle("SonyTen2","wweRaw","SmackDown");//User Input
		lr.save(l1);
		lr.save(l2);
		lr.save(l3);
		List<LifeStyle>nList = new ArrayList<>(); // Creating list Object
		nList.add(l1);
		nList.add(l2);
		nList.add(l3);
		
		when(lr.findAll()).thenReturn(nList);
		List<LifeStyle> lList1 = lsl.getAllLifeStyles();
		assertEquals(nList,lList1);
		verify(lr,times(1)).save(l1);
		verify(lr,times(1)).findAll();
		
		
		
	}
	

}