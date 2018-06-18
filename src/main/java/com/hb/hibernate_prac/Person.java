package com.hb.hibernate_prac;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.ParameterMode;
import javax.persistence.QueryHint;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@NamedQueries({ @NamedQuery(name = "get_person_by_name", query = "select p from Person p where name = :name"),
	@NamedQuery(name = "get_read_only_person_by_name", query = "select p from Person p where name = :name", hints = {
			@QueryHint(name = "org.hibernate.readOnly", value = "true") }) })
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "sp_person_phones", procedureName = "sp_person_phones", parameters = {
		@StoredProcedureParameter(name = "personId", type = Long.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "personPhones", type = Class.class, mode = ParameterMode.REF_CURSOR) }))
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String nickName;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	@OrderColumn(name = "order_id")
	private final List<Phone> phones = new ArrayList<Phone>();

	@ElementCollection
	@MapKeyEnumerated(EnumType.STRING)
	private final Map<AddressType, String> addresses = new HashMap<AddressType,String>();

	@Version
	private int version;

	public String getAddress() {
		return address;
	}

	public Map<AddressType, String> getAddresses() {
		return addresses;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public int getVersion() {
		return version;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	// Getters and setters are omitted for brevity

}
