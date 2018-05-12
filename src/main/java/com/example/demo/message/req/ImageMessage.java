package com.example.demo.message.req;

public class ImageMessage extends Message{
	
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
