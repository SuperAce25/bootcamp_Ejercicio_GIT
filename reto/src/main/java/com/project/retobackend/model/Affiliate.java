package com.project.retobackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "affiliates")
public class Affiliate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private Integer age;
	@Column(name = "mail")
	private String mail;
		
	
	public Affiliate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Affiliate(Integer id, String name, Integer age, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mail = mail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
