package com.project.retobackend.citas;

import java.time.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Appointment {
	
	private Integer id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateAppointment;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime hourAppointment;
	private Integer id_test;
	private Integer id_affiliate;
	
	
	public Appointment() {
		super();
	}

	public Appointment(Integer id, LocalDate dateAppointment, LocalTime hourAppointment, Integer id_test,
			Integer id_affiliate) {
		super();
		this.id = id;
		this.dateAppointment = dateAppointment;
		this.hourAppointment = hourAppointment;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(LocalDate dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public LocalTime getHourAppointment() {
		return hourAppointment;
	}

	public void setHourAppointment(LocalTime hourAppointment) {
		this.hourAppointment = hourAppointment;
	}

	public Integer getId_test() {
		return id_test;
	}

	public void setId_test(Integer id_test) {
		this.id_test = id_test;
	}

	public Integer getId_affiliate() {
		return id_affiliate;
	}

	public void setId_affiliate(Integer id_affiliate) {
		this.id_affiliate = id_affiliate;
	}
	
	
	
}
