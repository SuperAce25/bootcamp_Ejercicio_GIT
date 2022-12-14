package com.project.retobackend.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

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
import com.project.retobackend.model.Tests;
import com.project.retobackend.service.TestService;

@ExtendWith(MockitoExtension.class)
public class TestsControllerTest {
	@InjectMocks
private TestsController testsController;

	@Mock
	private TestService testsServicemock;
	
	//TestsService testsServicemock = Mockito.mock(TestsService.class);
	
	private List<Tests> testsList = new ArrayList<Tests>();
	private ResponseEntity<?> mockResponse;
	private Tests tests = new Tests();
	
	@BeforeEach
	void setUp() {
		testsList.clear();
		tests.setId(447);
		tests.setName("Tony Stark");
		tests.setDescription("Hola");
		
		testsList.add(tests);
	
	}
	
	@Test
	public void getlisttest(){
		testsList.add(tests);
		
		Mockito.when(testsServicemock.getlist()).thenReturn(testsList);
		var response = testsController.getlist();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void getlisttestnull(){
		testsList.clear();
		
		Mockito.when(testsServicemock.getlist()).thenReturn(testsList);
		var response = testsController.getlist();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	public void getbyidtest(){
		Mockito.when(testsServicemock.getbyid(11)).thenReturn(tests);
		var response = testsController.getbyid(11);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void getbyidnulltest(){
		Mockito.when(testsServicemock.getbyid(11)).thenReturn(new Tests());
		var response = testsController.getbyid(12);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void posttest(){
		var response = testsController.post(tests);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void posttestnull(){
		var response = testsController.post(new Tests());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void putttest(){
		Mockito.when(testsServicemock.existbyId(tests.getId())).thenReturn(true);
		var response = testsController.put(tests);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void putttestnull(){
		Mockito.when(testsServicemock.existbyId(tests.getId())).thenReturn(false);
		var response = testsController.put(tests);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void deletetest(){
		testsList.add(tests);
		Mockito.when(testsServicemock.existbyId(11)).thenReturn(true);
		var response = testsController.delete(11);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void deletenulltest(){
		testsList.add(tests);
		Mockito.when(testsServicemock.existbyId(11)).thenReturn(false);
		var response = testsController.delete(11);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	


}
