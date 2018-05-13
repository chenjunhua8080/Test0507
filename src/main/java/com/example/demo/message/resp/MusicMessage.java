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
public class MusicMessage extends Message{
	
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
	private Music Music;
	
	public MusicMessage() {
	}

	public MusicMessage(String toUserName, String fromUserName, long createTime, String msgType,
			com.example.demo.message.resp.Music music) {
		super(toUserName, fromUserName, createTime, msgType);
		Music = music;
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	
	

}
