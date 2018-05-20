package com.example.demo.temp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Temp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String touser;

	private String template_id;
	
	private String url;
	private String msgid;
	
	@Transient
	private TempData data;

	@Override
	public String toString() {
		return "Temp [id=" + id + ", touser=" + touser + ", template_id=" + template_id + ", url=" + url + ", msgid="
				+ msgid + ", data=" + data + "]";
	}

	public Temp() {
	}

	public Temp(String touser, String template_id, String url, TempData data) {
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}

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

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TempData getData() {
		return data;
	}

	public void setData(TempData data) {
		this.data = data;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	
	

}
