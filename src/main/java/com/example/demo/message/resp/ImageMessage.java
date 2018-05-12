package com.example.demo.message.resp;

public class ImageMessage extends Message{

	private Image Image;

	public ImageMessage() {
	}

	public ImageMessage(String toUserName, String fromUserName, long createTime, String msgType,
			com.example.demo.message.resp.Image image) {
		super(toUserName, fromUserName, createTime, msgType);
		Image = image;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	

	
	
}
