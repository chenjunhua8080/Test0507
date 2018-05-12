package com.example.demo.message.resp;

public class TextMessage extends Message{
	
	private String Content;

	public TextMessage() {
	}

	public TextMessage(String toUserName, String fromUserName, Integer createTime, String msgType, String content) {
		super(toUserName, fromUserName, createTime, msgType);
		Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
