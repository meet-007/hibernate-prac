package com.hb.hibernate_prac;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	private String type;

	@Column(name = "`number`")
	private String number;

	public Phone() {
	}

	public Phone(String type, String number) {
		this.type = type;
		this.number = number;
	}


	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}


	@Override
	public String toString() {
		return "Phone [type=" + type + ", number=" + number + "]";
	}


}
