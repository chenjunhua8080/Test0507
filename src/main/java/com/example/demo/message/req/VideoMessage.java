package com.example.demo.message.req;

public class VideoMessage extends Message{
	
	private String MediaId;
	private String Title;
	private String Description;
	public VideoMessage() {
	}
	public VideoMessage(String toUserName, String fromUserName, Integer createTime, String msgType, String mediaId,
			String title, String description) {
		super(toUserName, fromUserName, createTime, msgType);
		MediaId = mediaId;
		Title = title;
		Description = description;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	

}
