package com.project.retobackend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.retobackend.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findbydate(LocalDate appointmentdate);
	
	List<Appointment> findbyname(String name);
}
