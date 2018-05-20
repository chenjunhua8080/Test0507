package com.example.demo.custom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Custom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String kf_account;
	private String nickname;
	private String password;
	@Override
	public String toString() {
		return "Custom [id=" + id + ", kf_account=" + kf_account + ", nickname=" + nickname + ", password=" + password
				+ "]";
	}
	public Custom(String kf_account, String nickname, String password) {
		this.kf_account = kf_account;
		this.nickname = nickname;
		this.password = password;
	}
	public Custom() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
