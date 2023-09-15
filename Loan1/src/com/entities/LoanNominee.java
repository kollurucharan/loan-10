package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_Loan_Nominees")
public class LoanNominee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int lnom_id;
	String lnom_name;
	String lnom_relation;

	public int getLnom_id() {
		return lnom_id;
	}

	public void setLnom_id(int lnom_id) {
		this.lnom_id = lnom_id;
	}

	public String getLnom_name() {
		return lnom_name;
	}

	public void setLnom_name(String lnom_name) {
		this.lnom_name = lnom_name;
	}

	public String getLnom_relation() {
		return lnom_relation;
	}

	public void setLnom_relation(String lnom_relation) {
		this.lnom_relation = lnom_relation;
	}

	@Override
	public String toString() {
		return "LoanNominee [lnom_id=" + lnom_id + ", lnom_name=" + lnom_name + ", lnom_relation=" + lnom_relation
				+ "]";
	}

}
