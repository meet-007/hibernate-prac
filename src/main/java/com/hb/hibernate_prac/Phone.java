package com.hb.hibernate_prac;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyTemporal;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;

@Entity
public class Phone {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;

	@Column(name = "phone_number")
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(name = "phone_type")
	private PhoneType type;

	@OneToMany(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<Call> calls = new ArrayList<Call>();

	@OneToMany(mappedBy = "phone")
	@MapKey(name = "timestamp")
	@MapKeyTemporal(TemporalType.TIMESTAMP)
	private final Map<Date, Call> callHistory = new HashMap<Date, Call>();

	@ElementCollection
	private final List<Date> repairTimestamps = new ArrayList<Date>();


	public Phone() {

	}

	public Phone(String number) {
		this.number = number;
	}


	public Map<Date, Call> getCallHistory() {
		return callHistory;
	}

	public List<Call> getCalls() {
		return calls;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public Person getPerson() {
		return person;
	}

	public List<Date> getRepairTimestamps() {
		return repairTimestamps;
	}

	public PhoneType getType() {
		return type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	// Getters and setters are omitted for brevity

}