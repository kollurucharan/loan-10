package com.entities;

public class schedule {
	int id;
	int months;
	double emiPerMonth;
	double rateOfInterest;
	double total;

	public schedule() {
	}

	public schedule(int id, int months, double emiPerMonth, double rateOfInterest, double total) {

		super();
		this.id = id;
		this.months = months;
		this.emiPerMonth = emiPerMonth;
		this.rateOfInterest = rateOfInterest;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double getEmiPerMonth() {
		return emiPerMonth;
	}

	public void setEmiPerMonth(double emiPerMonth) {
		this.emiPerMonth = emiPerMonth;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	@Override
	public String toString() {
		return "schedule [months=" + months + ", emiPerMonth=" + emiPerMonth + ", rateOfInterest=" + rateOfInterest
				+ ", total=" + total + "]";
	}
}