package com.example.demo.message.resp;

public class VoiceMessage extends Message{

	private String MediaId;
	private String Format;
	private String Recognition;
	public VoiceMessage() {
	}

	public VoiceMessage(String toUserName, String fromUserName, Integer createTime, String msgType, Integer msgId,
			String mediaId, String format, String recognition) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		MediaId = mediaId;
		Format = format;
		Recognition = recognition;
	}

	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	
	
	
}
