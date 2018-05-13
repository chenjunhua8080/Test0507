package com.example.demo.message.resp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ImageMessage extends Message{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(cascade=CascadeType.ALL)
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
