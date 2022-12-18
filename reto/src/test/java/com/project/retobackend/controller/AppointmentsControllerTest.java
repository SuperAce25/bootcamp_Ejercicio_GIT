package com.project.retobackend.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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


import com.project.retobackend.model.Appointment;
import com.project.retobackend.service.AppointmentService;

@ExtendWith(MockitoExtension.class)
public class AppointmentsControllerTest {
	
	@InjectMocks
	private AppointmentsController appointmentController;
	
	@Mock
	private AppointmentService appointmentServicemock;
	
	private List<Appointment> appointmentList = new ArrayList<Appointment>();
	
	private Appointment appointment = new Appointment();
	
	
	@BeforeEach
	public void setUp() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyy");
		appointment.setId(Long.valueOf("11"));
		appointment.setDateAppointment(LocalDate.parse("10/12/2022", df));
		appointment.setHourAppointment(LocalTime.parse("11:00"));
		appointment.setIdtest(4);
		appointment.setIdaffiliate(455);
	}
	
	@Test
	public void getlisttest(){
		appointmentList.add(appointment);
		
		Mockito.when(appointmentServicemock.getlist()).thenReturn(appointmentList);
		var response = appointmentController.getlist();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void getlisttestempty(){
		Mockito.when(appointmentServicemock.getlist()).thenReturn(appointmentList);
		var response = appointmentController.getlist();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	public void getbyidtest(){
		
		Mockito.when(appointmentServicemock.getbyid(11)).thenReturn(appointment);
		var response = appointmentController.getbyid(11);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	public void getbyidemptytest(){
		
		Mockito.when(appointmentServicemock.getbyid(11)).thenReturn(appointment);
		var response = appointmentController.getbyid(12);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		
	}
	
	@Test
	public void posttest(){
		var response = appointmentController.post(appointment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void posttestnull(){
		var response = appointmentController.post(new Appointment());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void putttest(){
		Mockito.when(appointmentServicemock.existbyId(appointment.getId())).thenReturn(true);
		var response = appointmentController.put(appointment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void putttestnull(){
		Mockito.when(appointmentServicemock.existbyId(appointment.getId())).thenReturn(false);
		var response = appointmentController.put(appointment);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void deletetest(){
		appointmentList.add(appointment);
		Mockito.when(appointmentServicemock.existbyId(11)).thenReturn(true);
		var response = appointmentController.delete(11);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void deletenulltest(){
		Mockito.when(appointmentServicemock.existbyId(11)).thenReturn(false);
		var response = appointmentController.delete(11);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	public void getbydatetest(){
		appointmentList.add(appointment);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate dateexample = LocalDate.parse("10/12/2022", df);
		
		Mockito.when(appointmentServicemock.findbydate(dateexample)).thenReturn(appointmentList);
		var response = appointmentController.getbydate(dateexample);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void getbydatetestnull(){
		appointmentList.add(appointment);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate dateexample = LocalDate.parse("11/12/2022", df);
		
		Mockito.when(appointmentServicemock.findbydate(dateexample)).thenReturn(new ArrayList<Appointment>());
		var response = appointmentController.getbydate(dateexample);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	public void getaffiliateidtest(){
		appointmentList.add(appointment);
		
		Mockito.when(appointmentServicemock.findbyaffiliate(455)).thenReturn(appointmentList);
		var response = appointmentController.getbyaffiliates(455);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void getaffiliateidnulltest(){
		appointmentList.add(appointment);
		
		Mockito.when(appointmentServicemock.findbyaffiliate(44)).thenReturn(new ArrayList<Appointment>());
		var response = appointmentController.getbyaffiliates(44);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	
	
}
