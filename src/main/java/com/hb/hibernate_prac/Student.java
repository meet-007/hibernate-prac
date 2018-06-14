package com.hb.hibernate_prac;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Entity()
@Table(name = "student")
public class Student {
	@Id
	@Generated(GenerationTime.NEVER)
	@GeneratedValue(generator = "increment")
	private int id;
	private String roll_no;
	private String name;
	@ElementCollection
	@JoinTable(name = "STUDENT_CONTACT", joinColumns = @JoinColumn(name = "STUDENT_ID"))
	// @GenericGenerator(name = "seuence" ,strategy="sequence")
	@CollectionId(columns = { @Column(name = "asdf") }, generator = "sequence", type = @Type(type = "long"))
	private final List<Phone> phones = new ArrayList<Phone>();

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Phone> getPhones() {
		return phones;
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
