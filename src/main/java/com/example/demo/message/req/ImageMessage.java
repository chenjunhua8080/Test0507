package com.example.demo.message.req;

public class ImageMessage extends Message{

	private String MediaId;

	public ImageMessage() {
	}

	public ImageMessage(String toUserName, String fromUserName, Integer createTime, String msgType, String mediaId) {
		super(toUserName, fromUserName, createTime, msgType);
		MediaId = mediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
