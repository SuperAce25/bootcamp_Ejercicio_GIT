package com.project.retobackend.controller;

import java.util.ArrayList;

import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.retobackend.model.Affiliate;
import com.project.retobackend.service.AffiliateService;

@ExtendWith(MockitoExtension.class)
public class AffiliatesControllerTest {
	
	@InjectMocks
	private AffiliatesController affiliateController;
	
	@Mock
	private AffiliateService affiliateServicemock;
	
	//AffiliateService affiliateServicemock = Mockito.mock(AffiliateService.class);
	
	private List<Affiliate> affiliateList = new ArrayList<Affiliate>();
	private ResponseEntity<?> mockResponse;
	private Affiliate affiliate = new Affiliate();
	
	@BeforeEach
	void setUp() {
		affiliateList.clear();
		affiliate.setId(447);
		affiliate.setName("Tony Stark");
		affiliate.setAge(40);
		affiliate.setMail("ironman@marvel.com");
		
		affiliateList.add(affiliate);

	}
	
	@Test
	public void getlisttest(){
		affiliateList.add(affiliate);
		
		Mockito.when(affiliateServicemock.getlist()).thenReturn(affiliateList);
		var response = affiliateController.getlist();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void getlisttestnull(){
		affiliateList.clear();
		Mockito.when(affiliateServicemock.getlist()).thenReturn(affiliateList);
		var response = affiliateController.getlist();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	public void getbyidtest(){
		Mockito.when(affiliateServicemock.getbyid(11)).thenReturn(affiliate);
		var response = affiliateController.getbyid(11);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void getbyidnulltest(){
		Mockito.when(affiliateServicemock.getbyid(11)).thenReturn(new Affiliate());
		var response = affiliateController.getbyid(12);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void posttest(){
		var response = affiliateController.post(affiliate);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void posttestnull(){
		var response = affiliateController.post(new Affiliate());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void putttest(){
		Mockito.when(affiliateServicemock.existbyId(affiliate.getId())).thenReturn(true);
		var response = affiliateController.put(affiliate);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void putttestnull(){
		Mockito.when(affiliateServicemock.existbyId(affiliate.getId())).thenReturn(false);
		var response = affiliateController.put(affiliate);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void deletetest(){
		affiliateList.add(affiliate);
		Mockito.when(affiliateServicemock.existbyId(11)).thenReturn(true);
		var response = affiliateController.delete(11);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void deletenulltest(){
		affiliateList.add(affiliate);
		Mockito.when(affiliateServicemock.existbyId(11)).thenReturn(false);
		var response = affiliateController.delete(11);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

}
