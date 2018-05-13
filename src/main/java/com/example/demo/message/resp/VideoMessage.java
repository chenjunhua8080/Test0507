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
public class VideoMessage extends Message{
	
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
	private Video Video;

	public VideoMessage() {
	}

	public VideoMessage(String toUserName, String fromUserName, long createTime, String msgType,
			com.example.demo.message.resp.Video video) {
		super(toUserName, fromUserName, createTime, msgType);
		Video = video;
	}

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

	
	

}
