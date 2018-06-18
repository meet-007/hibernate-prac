package com.hb.hibernate_prac;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal amount;

	private boolean completed;

	@ManyToOne
	private Person person;

	public BigDecimal getAmount() {
		return amount;
	}

	public Long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	//Getters and setters are omitted for brevity

}
