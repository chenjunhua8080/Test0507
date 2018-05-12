package com.example.demo.message.resp;

public class VideoMessage extends Message{

	private String MediaId;
	private String ThumbMediaId;
	
	
	public VideoMessage() {
	}
	
	public VideoMessage(String toUserName, String fromUserName, Integer createTime, String msgType, Integer msgId,
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
