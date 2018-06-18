package com.hb.hibernate_prac;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
//@NamedQuery(name = "Student.byid", query = "from Student where id = ?1")
@NamedNativeQuery(name = "Student.byid.sql", query = "select * from student where id = ?",resultClass=Student.class)
@Entity()
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(generator = "increment")
	private int id;
	@Type(type = "nstring")
	// @Transient
	private String roll_no;
	// @Column(name="NAME")
	// private String name;
	private StudentName studentName;
	private StudentName studentNickName;
	//	@OneToOne
	//	private Laptop laptop;

	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	private List<Laptop> laptops;

	public int getId() {
		return id;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public String getRoll_no() {
		return roll_no;
	}

	//	public Laptop getLaptop() {
	//		return laptop;
	//	}


	public StudentName getStudentName() {
		return studentName;
	}

	public StudentName getStudentNickName() {
		return studentNickName;
	}




	public void setId(int id) {
		this.id = id;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}


	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}



	public void setStudentName(StudentName studentName) {
		this.studentName = studentName;
	}

	public void setStudentNickName(StudentName studentNickName) {
		this.studentNickName = studentNickName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll_no=" + roll_no + ", studentName=" + studentName + "]";
	}





}
