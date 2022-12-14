package com.project.retobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.retobackend.model.Appointment;
import com.project.retobackend.repository.AppointmentRepository;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appRepo;
	
	@GetMapping("/api/appointments/name")
	public ResponseEntity<List<Appointment>> getbyname(@RequestParam String name){
		return new ResponseEntity<List<Appointment>>(appRepo.findbyname(name), HttpStatus.OK);
	}
	
	
}
