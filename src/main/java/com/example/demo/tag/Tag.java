package com.example.demo.tag;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int tagid;

	private String name;

	private String[] openid;


	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagid=" + tagid + ", name=" + name + ", openid=" + Arrays.toString(openid) + "]";
	}
	public Tag() {
	}
	public Tag(String name) {
		this.name = name;
	}

	public Tag(int tagid) {
		this.tagid=tagid;
	}
	
	

	public Tag(int tagid, String name) {
		this.tagid = tagid;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getOpenid() {
		return openid;
	}

	public void setOpenid(String[] openid) {
		this.openid = openid;
	}
	public int getTagid() {
		return tagid;
	}
	public void setTagid(int tagid) {
		this.tagid = tagid;
	}
	
	
}
