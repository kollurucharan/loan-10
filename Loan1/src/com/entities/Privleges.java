package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_privileges")
public class Privleges {
	@Id
	int priv_id;
	String priv_name;
	String priv_rpattern; 
	String priv_action;
	@Override
	public String toString() {
		return "Privleges [priv_id=" + priv_id + ", priv_name=" + priv_name + ", priv_rpattern=" + priv_rpattern
				+ ", priv_action=" + priv_action + "]";
	}
	public int getPriv_id() {
		return priv_id;
	}
	public void setPriv_id(int priv_id) {
		this.priv_id = priv_id;
	}
	public String getPriv_name() {
		return priv_name;
	}
	public void setPriv_name(String priv_name) {
		this.priv_name = priv_name;
	}
	public String getPriv_rpattern() {
		return priv_rpattern;
	}
	public void setPriv_rpattern(String priv_rpattern) {
		this.priv_rpattern = priv_rpattern;
	}
	public String getPriv_action() {
		return priv_action;
	}
	public void setPriv_action(String priv_action) {
		this.priv_action = priv_action;
	}
}
