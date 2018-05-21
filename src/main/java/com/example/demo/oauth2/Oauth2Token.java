package com.example.demo.oauth2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Oauth2Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String openid;
	private String access_token;
	private String refresh_token;
	private String scope;
	private int expires_in;
	private Date createDate;
	@Override
	public String toString() {
		return "Oauth2Token [id=" + id + ", openid=" + openid + ", access_token=" + access_token + ", refresh_token="
				+ refresh_token + ", scope=" + scope + ", expires_in=" + expires_in + ", createDate=" + createDate
				+ "]";
	}
	public Oauth2Token() {
	}
	public Oauth2Token(String openid, String access_token, String scope) {
		this.openid = openid;
		this.access_token = access_token;
		this.scope = scope;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
