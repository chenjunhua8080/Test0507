package com.example.demo.message.req;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class ImageMessage extends Message{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String PicUrl;
	private String MediaId;
	public ImageMessage() {
	}
	public ImageMessage(String toUserName, String fromUserName, Integer createTime, String msgType, Integer msgId,
			String picUrl, String mediaId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		PicUrl = picUrl;
		MediaId = mediaId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	

}
