package com.example.demo.message.resp;

public class LinkMessage extends Message{
	
	private String Title;
	private String Description;
	private String Url;
	public LinkMessage() {
	}
	public LinkMessage(String title, String description, String url) {
		Title = title;
		Description = description;
		Url = url;
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
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	

}
