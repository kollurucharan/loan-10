package com.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_Customer")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cust_id;
	String cust_fname;
	String cust_lname;
	Date cust_dob;
	String cust_panno;
	long cust_mobile;
	String cust_address;
	String cust_gaurd_name;
	int luuser;

	public int getLuuser() {
		return luuser;
	}

	public void setLuuser(int luuser) {
		this.luuser = luuser;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_fname() {
		return cust_fname;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public Date getCust_dob() {
		return cust_dob;
	}

	public void setCust_dob(String cust_dob) {
		Date x = Date.valueOf(cust_dob);
		this.cust_dob = x;
	}

	public String getCust_panno() {
		return cust_panno;
	}

	public void setCust_panno(String cust_panno) {
		this.cust_panno = cust_panno;
	}

	public long getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(long cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_gaurd_name() {
		return cust_gaurd_name;
	}

	public void setCust_gaurd_name(String cust_gaurd_name) {
		this.cust_gaurd_name = cust_gaurd_name;
	}

	@Override
	public String toString() {
		return "CustomerDetails [cust_id=" + cust_id + ", cust_fname=" + cust_fname + ", cust_lname=" + cust_lname
				+ ", cust_dob=" + cust_dob + ", cust_panno=" + cust_panno + ", cust_mobile=" + cust_mobile
				+ ", cust_address=" + cust_address + ", cust_gaurd_name=" + cust_gaurd_name + "]";
	}

}
