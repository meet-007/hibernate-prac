package com.hb.hibernate_prac;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity(name = "student_details")
@Subselect("select" +
		"SELECT s.id as id, s.name as studentName,sp.number as phone" +
		",sp.type as type FROM Student s left outer join STUDENT_CONTACT sp" +
		"on s.id = sp.Student_id;"
		)
@Synchronize( {"student", "Student_phones"} )
public class StudDetails {

	@Id
	private Long id;

	private String studentName;

	private String phone;

	private String type;

	public Long getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getType() {
		return type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		phone = phone;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setType(String type) {
		this.type = type;
	}




}
