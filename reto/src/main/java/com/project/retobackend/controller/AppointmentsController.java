package com.project.retobackend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.retobackend.model.Appointment;
import com.project.retobackend.model.Tests;
import com.project.retobackend.repository.AppointmentRepository;
import com.project.retobackend.service.AppointmentService;

@RestController
public class AppointmentsController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping("/")
	public String inicio() {
		return "Bienvenido a mi presentacion del reto";
	}
	@GetMapping("/api/appointments")
	public ResponseEntity<List <Appointment>> getlist(){
		if (appointmentService.getlist().isEmpty()) {
			return new ResponseEntity<List<Appointment>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Appointment>>(appointmentService.getlist(),null, HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/appointments/{id}")
	public ResponseEntity<Appointment> getbyid(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<Appointment>(appointmentService.getbyid(id), null , HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/api/appointments")
	public ResponseEntity<String> post(@RequestBody Appointment appointment){ 
		if (appointment.getIdaffiliate() != null) {
			appointmentService.saveOrUpdate(appointment);  
			return new ResponseEntity<String>("Created", null, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String>("Not Created", null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/appointments")  
	public ResponseEntity<String> put(@RequestBody Appointment appointment){
		if (appointmentService.existbyId(appointment.getId())) {
			appointmentService.update(appointment);  
			return new ResponseEntity<String>("Updated", null, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String>("Id not found", null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/appointments/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		if (appointmentService.existbyId(id)) {
			appointmentService.delete(id);
			return new ResponseEntity<String> (HttpStatus.OK);			
		} else{
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/api/appointments/findbyaffiliate")
	public ResponseEntity<List<Appointment>> getbyaffiliates(@RequestParam("affiliate") Integer affiliate){
		if(appointmentService.findbyaffiliate(affiliate).isEmpty()) {
			return new ResponseEntity<List<Appointment>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Appointment>> (appointmentService.findbyaffiliate(affiliate),null, HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/appointments/findbydate")
	public ResponseEntity<List<Appointment>> getbydate(@RequestParam("date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	LocalDate date){
		if(appointmentService.findbydate(date).isEmpty()) {
			return new ResponseEntity<List<Appointment>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Appointment>>(appointmentService.findbydate(date), null, HttpStatus.OK);
		}
	}
}

