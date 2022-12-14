package com.project.retobackend.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;

public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "hour")
	private LocalTime hour;
	@Column(name = "id_test")
	private Integer id_test;
	@Column(name = "id_affiliate")
	private Integer id_affiliate;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long id, LocalDate date, LocalTime hour, Integer id_test, Integer id_affiliate) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
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
