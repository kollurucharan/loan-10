package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_user_privleges")
public class UserPrivleges {
	@Id
	int user_id;
	int priv_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPriv_id() {
		return priv_id;
	}
	public void setPriv_id(int priv_id) {
		this.priv_id = priv_id;
	}
	@Override
	public String toString() {
		return "UserPrivleges [user_id=" + user_id + ", priv_id=" + priv_id + "]";
	}
}
