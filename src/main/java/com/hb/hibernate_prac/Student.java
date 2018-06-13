package com.hb.hibernate_prac;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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

	@ManyToMany(mappedBy="students",fetch=FetchType.EAGER)
	private List<Laptop> laptops;

	public int getId() {
		return id;
	}

	//	public Laptop getLaptop() {
	//		return laptop;
	//	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public String getRoll_no() {
		return roll_no;
	}

	public StudentName getStudentName() {
		return studentName;
	}




	public StudentName getStudentNickName() {
		return studentNickName;
	}

	public void setId(int id) {
		this.id = id;
	}
	//
	//	public void setLaptop(Laptop laptop) {
	//		this.laptop = laptop;
	//	}

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
