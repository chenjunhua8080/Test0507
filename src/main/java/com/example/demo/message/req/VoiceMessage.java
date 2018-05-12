package com.example.demo.message.req;

public class VoiceMessage extends Message{
	
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public VoiceMessage() {
	}

	public VoiceMessage(String toUserName, String fromUserName, Integer createTime, String msgType, String mediaId) {
		super(toUserName, fromUserName, createTime, msgType);
		MediaId = mediaId;
	}
	
	

}
