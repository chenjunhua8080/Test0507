package com.example.demo.oauth2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String openid;
	private String nickname;
	private int sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	@Transient
	private String[] privilege;
	private String privilegeStr;
	private String unionid;
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", province="
				+ province + ", city=" + city + ", country=" + country + ", headimgurl=" + headimgurl + ", privilege="
				+ privilege + ", unionid=" + unionid + "]";
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	public String getPrivilegeStr() {
		return privilegeStr;
	}
	public void setPrivilegeStr(String privilegeStr) {
		this.privilegeStr = privilegeStr;
	}
}
