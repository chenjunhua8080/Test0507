package com.example.demo.message.req;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ShortVideoMessage extends Message{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String MediaId;
	private String ThumbMediaId;
	public ShortVideoMessage() {
	}
	public ShortVideoMessage(String toUserName, String fromUserName, Integer createTime, String msgType, Integer msgId,
			String mediaId, String thumbMediaId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		MediaId = mediaId;
		ThumbMediaId = thumbMediaId;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	

}
