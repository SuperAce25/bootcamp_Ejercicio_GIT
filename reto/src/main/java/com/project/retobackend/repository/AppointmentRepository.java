package com.project.retobackend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.retobackend.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository <Appointment, Long> {
	
	//List<Appointment> getbydate(LocalDate date);
	public abstract List<Appointment> findByidaffiliate(Integer id_affiliate);

	public abstract List<Appointment> findBydateAppointment(LocalDate appointmentdate);
}
