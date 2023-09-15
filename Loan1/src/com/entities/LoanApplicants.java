package com.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_loanapplicants")
public class LoanApplicants {
	@Override
	public String toString() {
		return "LoanApplicants [lapp_id=" + lapp_id + ", lapp_cust_id=" + lapp_cust_id + ", lapp_date=" + lapp_date
				+ ", lapp_ltype_id=" + lapp_ltype_id + ", lapp_amount=" + lapp_amount + ", lapp_emirange_from="
				+ lapp_emirange_from + ", lapp_emirange_to=" + lapp_emirange_to + ", lapp_months_req=" + lapp_months_req
				+ ", lapp_cibil_score=" + lapp_cibil_score + ", lapp_annual_income=" + lapp_annual_income
				+ ", lapp_dispos_income=" + lapp_dispos_income + ", lapp_status=" + lapp_status
				+ ", lapp_conclusion_remarks=" + lapp_conclusion_remarks + ", lapp_lnom_id=" + lapp_lnom_id + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int lapp_id;
	int lapp_cust_id;
	Date lapp_date;
	int lapp_ltype_id;
	double lapp_amount;
	double lapp_emirange_from;
	double lapp_emirange_to;
	int lapp_months_req;
	int lapp_cibil_score;
	double lapp_annual_income;
	double lapp_dispos_income;
	String lapp_status;
	String lapp_conclusion_remarks;
	int lapp_lnom_id;

	public int getLapp_id() {
		return lapp_id;
	}

	public void setLapp_id(int lapp_id) {
		this.lapp_id = lapp_id;
	}

	public int getLapp_cust_id() {
		return lapp_cust_id;
	}

	public void setLapp_cust_id(int lapp_cust_id) {
		this.lapp_cust_id = lapp_cust_id;
	}

	public Date getLapp_date() {
		return lapp_date;
	}

	public void setLapp_date(String lapp_date) {
		Date x = Date.valueOf(lapp_date);
		this.lapp_date = x;
	}

	public int getLapp_ltype_id() {
		return lapp_ltype_id;
	}

	public void setLapp_ltype_id(int lapp_ltype_id) {
		this.lapp_ltype_id = lapp_ltype_id;
	}

	public double getLapp_amount() {
		return lapp_amount;
	}

	public void setLapp_amount(double lapp_amount) {
		this.lapp_amount = lapp_amount;
	}

	public double getLapp_emirange_from() {
		return lapp_emirange_from;
	}

	public void setLapp_emirange_from(double lapp_emirange_from) {
		this.lapp_emirange_from = lapp_emirange_from;
	}

	public double getLapp_emirange_to() {
		return lapp_emirange_to;
	}

	public void setLapp_emirange_to(double lapp_emirange_to) {
		this.lapp_emirange_to = lapp_emirange_to;
	}

	public int getLapp_months_req() {
		return lapp_months_req;
	}

	public void setLapp_months_req(int lapp_months_req) {
		this.lapp_months_req = lapp_months_req;
	}

	public int getLapp_cibil_score() {
		return lapp_cibil_score;
	}

	public void setLapp_cibil_score(int lapp_cibil_score) {
		this.lapp_cibil_score = lapp_cibil_score;
	}

	public double getLapp_annual_income() {
		return lapp_annual_income;
	}

	public void setLapp_annual_income(double lapp_annual_income) {
		this.lapp_annual_income = lapp_annual_income;
	}

	public double getLapp_dispos_income() {
		return lapp_dispos_income;
	}

	public void setLapp_dispos_income(double lapp_dispos_income) {
		this.lapp_dispos_income = lapp_dispos_income;
	}

	public String getLapp_status() {
		return lapp_status;
	}

	public void setLapp_status(String lapp_status) {
		this.lapp_status = lapp_status;
	}

	public String getLapp_conclusion_remarks() {
		return lapp_conclusion_remarks;
	}

	public void setLapp_conclusion_remarks(String lapp_conclusion_remarks) {
		this.lapp_conclusion_remarks = lapp_conclusion_remarks;
	}

	public int getLapp_lnom_id() {
		return lapp_lnom_id;
	}

	public void setLapp_lnom_id(int lapp_lnom_id) {
		this.lapp_lnom_id = lapp_lnom_id;
	}

}
