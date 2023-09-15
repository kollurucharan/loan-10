package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_loanType")
public class LoanType {
	@Id
	int ltype_id;
	String ltype_name;
	String ltype_desc;

	public int getLtype_id() {
		return ltype_id;
	}

	public void setLtype_id(int ltype_id) {
		this.ltype_id = ltype_id;
	}

	public String getLtype_name() {
		return ltype_name;
	}

	public void setLtype_name(String ltype_name) {
		this.ltype_name = ltype_name;
	}

	public String getLtype_desc() {
		return ltype_desc;
	}

	public void setLtype_desc(String ltype_desc) {
		this.ltype_desc = ltype_desc;
	}

}
