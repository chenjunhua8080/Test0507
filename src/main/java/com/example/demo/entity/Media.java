package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String path;
	
	private String type;
	
	private String media_id;
	
	private String thumb_media_id;
	
	private String created_at;

	private String url;
	
	private int isForever;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Media() {
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsForever() {
		return isForever;
	}

	public void setIsForever(int isForever) {
		this.isForever = isForever;
	}

	public Media(String path, String type, String media_id, String thumb_media_id, String created_at, String url,
			int isForever) {
		super();
		this.path = path;
		this.type = type;
		this.media_id = media_id;
		this.thumb_media_id = thumb_media_id;
		this.created_at = created_at;
		this.url = url;
		this.isForever = isForever;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", path=" + path + ", type=" + type + ", media_id=" + media_id + ", thumb_media_id="
				+ thumb_media_id + ", created_at=" + created_at + ", url=" + url + ", isForever=" + isForever + "]";
	}



	
	
	

}
