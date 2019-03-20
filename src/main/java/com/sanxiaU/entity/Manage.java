package com.sanxiaU.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Manage implements Serializable {

	private Long mg_mrid;
	private String mg_user;
	private String mg_pwd;
	private Character mg_status;
	private String mg_time;
	private String mg_ip;

	public Long getMg_mrid() {
		return mg_mrid;
	}

	public void setMg_mrid(Long mg_mrid) {
		this.mg_mrid = mg_mrid;
	}

	public String getMg_user() {
		return mg_user;
	}

	public void setMg_user(String mg_user) {
		this.mg_user = mg_user;
	}

	public String getMg_pwd() {
		return mg_pwd;
	}

	public void setMg_pwd(String mg_pwd) {
		this.mg_pwd = mg_pwd;
	}

	public Character getMg_status() {
		return mg_status;
	}

	public void setMg_status(Character mg_status) {
		this.mg_status = mg_status;
	}

	

	public Manage() {

	}
	public Manage(String mg_user) {
		super();
		this.mg_user = mg_user;
	}
	public Manage(String mg_user, String mg_pwd) {
		super();
		this.mg_user = mg_user;
		this.mg_pwd = mg_pwd;

	}
	

	@Override
	public String toString() {
		return "Manage [mg_mrid=" + mg_mrid + ", mg_user=" + mg_user + ", mg_pwd=" + mg_pwd + ", mg_status=" + mg_status
				+ ", mg_time=" + mg_time + ", mg_ip=" + mg_ip + "]";
	}

	public String getMg_time() {
		return mg_time;
	}

	public void setMg_time(String mg_time) {
		
		this.mg_time = mg_time;
	}

	public String getMg_ip() {
		return mg_ip;
	}

	public void setMg_ip(String mg_ip) {
		this.mg_ip = mg_ip;
	}
}
