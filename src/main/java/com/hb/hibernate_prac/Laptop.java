package com.hb.hibernate_prac;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="laptop")
public class Laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String company;
	//
	//	@ManyToMany
	//	private List<Student> students;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@NotFound(action = NotFoundAction.EXCEPTION)
	private Student student;

	public String getCompany() {
		return company;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Student getStudent() {
		return student;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", company=" + company + "]";
	}



}
