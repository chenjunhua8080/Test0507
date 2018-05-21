package com.example.demo.qrcode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Long2Short {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String action;
	
	private String long_url;
	
	private String short_url;

	@Override
	public String toString() {
		return "Long2Short [id=" + id + ", action=" + action + ", long_url=" + long_url + ", short_url=" + short_url
				+ "]";
	}

	public Long2Short() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLong_url() {
		return long_url;
	}

	public void setLong_url(String long_url) {
		this.long_url = long_url;
	}

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
	
	
	

}
