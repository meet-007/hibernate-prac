package com.hb.hibernate_prac;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_call")
public class Call {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Phone  phone;

	@Column(name = "call_timestamp")
	private Date timestamp;

	private int duration;

	public int getDuration() {
		return duration;
	}

	public Long getId() {
		return id;
	}

	public Phone getPhone() {
		return phone;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	//Getters and setters are omitted for brevity

}