package com.example.demo.message.resp;

public class MusicMessage extends Message{
	
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
