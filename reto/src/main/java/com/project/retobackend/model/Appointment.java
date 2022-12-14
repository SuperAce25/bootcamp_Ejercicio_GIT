package com.project.retobackend.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
@Entity
//defining class name as table name
@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "dateAppointment")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateAppointment;
	@Column(name = "hourAppointment")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime hourAppointment;
	@Column(name = "idtest")
	private Integer idtest;
	@Column(name = "idaffiliate")
	private Integer idaffiliate;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getIdtest() {
		return idtest;
	}

	public void setIdtest(Integer idtest) {
		this.idtest = idtest;
	}

	public Integer getIdaffiliate() {
		return idaffiliate;
	}

	public void setIdaffiliate(Integer idaffiliate) {
		this.idaffiliate = idaffiliate;
	}

	

	
}
