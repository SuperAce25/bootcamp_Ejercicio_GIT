package com.project.retobackend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.retobackend.model.Appointment;
import com.project.retobackend.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	//Entrega todo el listado de registros de la tabla, con todos sus campos
	public List <Appointment> getlist(){
		List <Appointment> appointments = new ArrayList<Appointment>();
		appointmentRepository.findAll().forEach(appointment1 -> appointments.add(appointment1));
		return appointments;
	}
	//Entrega un solo registro que coincida con el id que llega por parámetro, con todos sus campos
	public Appointment getbyid(long id) {
		return appointmentRepository.findById(id).get();
	}
	//Permite almacenar un nuevo registro en la tabla, recibe en el body la estructura de la tabla, sin el campo id
	public void saveOrUpdate(Appointment appointments) {
		appointmentRepository.save(appointments);
	}
	//Permite eliminar un registro de la tabla, el cual debe coincidir con el id recibido por parámetro
	public void delete(long id) {
		appointmentRepository.deleteById(id);
	}
	//Permite actualizar un campo de la tabla, teniendo presente que el campo id no es un campo modificable, recibe un json con todos los campos de la tabla
	public void update(Appointment appointment) {
		//appointmentRepository.findById(appointment.getId()).orElseThrow();
		appointmentRepository.save(appointment);
	}
	
	//Entrega todos los appointments por id_affiliate
	public List <Appointment> findbyaffiliate(Integer id_affiliate){
		return appointmentRepository.findByidaffiliate(id_affiliate);
	}
	public List<Appointment> findbydate(LocalDate appointmentdate) {
		return appointmentRepository.findBydateAppointment(appointmentdate);
	}
	
	public boolean existbyId(long id) {
		try {
			return appointmentRepository.existsById(id);
		} catch (Exception e) {
			return false;
		}
	}
	
}
