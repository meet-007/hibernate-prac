package com.hb.hibernate_prac;

import javax.persistence.Embeddable;

/**
 * @author inexture
 *
 */
@Embeddable
public class StudentName {
	private String fname;
	private String mname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getMname() {
		return mname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "StudentName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}


}
