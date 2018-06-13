package com.hb.hibernate_prac;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(generator = "increment")
	private int id;
	private String roll_no;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRoll_no() {
		return roll_no;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll_no=" + roll_no + ", name=" + name + "]";
	}



}
