package com.example.demo.qrcode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Qrcode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String expire_seconds;
	
	private String action_name;
	
	@Transient
	private Scene action_info;
	
	private String action_info_str;

	private String ticket;
	
	private String url;

	@Override
	public String toString() {
		return "Qrcode [id=" + id + ", expire_seconds=" + expire_seconds + ", action_name=" + action_name
				+ ", action_info=" + action_info + ", action_info_str=" + action_info_str + ", ticket=" + ticket
				+ ", url=" + url + "]";
	}

	public Qrcode(String expire_seconds, String action_name, Scene action_info, String action_info_str) {
		this.expire_seconds = expire_seconds;
		this.action_name = action_name;
		this.action_info = action_info;
		this.action_info_str = action_info_str;
	}

	public Qrcode() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public Scene getAction_info() {
		return action_info;
	}

	public void setAction_info(Scene action_info) {
		this.action_info = action_info;
	}

	public String getAction_info_str() {
		return action_info_str;
	}

	public void setAction_info_str(String action_info_str) {
		this.action_info_str = action_info_str;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
