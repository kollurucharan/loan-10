package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_EMISchedule")
public class EMISchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int EMIid;
	String EMIDate;
	double EMIAmount;
	double remainingAmount;
	int lap_id;

	public EMISchedule() {

	}

	public EMISchedule(String eMIDate, double eMIAmount, double remainingAmount, int lap_id) {
		super();
		EMIDate = eMIDate;
		EMIAmount = eMIAmount;
		this.remainingAmount = remainingAmount;
		this.lap_id=lap_id;
	}

	public int getLap_id() {
		return lap_id;
	}

	public void setLap_id(int lap_id) {
		this.lap_id = lap_id;
	}

	public int getEMIid() {
		return EMIid;
	}

	public void setEMIid(int eMIid) {
		EMIid = eMIid;
	}

	public String getEMIDate() {
		return EMIDate;
	}

	public void setEMIDate(String eMIDate) {
		EMIDate = eMIDate;
	}

	public double getEMIAmount() {
		return EMIAmount;
	}

	public void setEMIAmount(double eMIAmount) {
		EMIAmount = eMIAmount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	@Override
	public String toString() {
		return "EMISchedule [EMIid=" + EMIid + ", EMIDate=" + EMIDate + ", EMIAmount=" + EMIAmount
				+ ", remainingAmount=" + remainingAmount + ", lap_id=" + lap_id + "]";
	}

}
