package com.hb.hibernate_prac;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop {

	@Id
	@GeneratedValue(generator="increment")
	private int id;
	private String name;
	private String company;

	@ManyToMany
	private List<Student> students;

	public String getCompany() {
		return company;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Student> getStudent() {
		return students;
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
	public void setStudent(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", company=" + company + "]";
	}



}
