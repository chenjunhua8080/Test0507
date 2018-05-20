package com.example.demo.custom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table
public class CustomMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String touser;
	private String msgtype;
	private String customservice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getCustomservice() {
		return customservice;
	}
	public void setCustomservice(String customservice) {
		this.customservice = customservice;
	}
	public CustomMessage() {
	}
	public CustomMessage(String touser, String msgtype, String customservice) {
		this.touser = touser;
		this.msgtype = msgtype;
		this.customservice = customservice;
	}
	
	
	
	

}
