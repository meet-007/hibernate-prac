package com.hb.hibernate_prac;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Partner {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	//Getters and setters are omitted for brevity

}