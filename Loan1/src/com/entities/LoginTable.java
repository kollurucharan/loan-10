package com.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lrc_userLogin")
public class LoginTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int user_id;
	String user_name;
	String user_pwd;
	String user_email;
	String user_recoverymail;
	long user_mobile;
	Date user_cdate;
	String user_type;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_recoverymail() {
		return user_recoverymail;
	}

	public void setUser_recoverymail(String user_recoverymail) {
		this.user_recoverymail = user_recoverymail;
	}

	public long getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(long user_mobile) {
		this.user_mobile = user_mobile;
	}

	public Date getUser_cdate() {
		return user_cdate;
	}

	public void setUser_cdate(String user_cdate) {
		Date x = Date.valueOf(user_cdate);
		this.user_cdate = x;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

}
