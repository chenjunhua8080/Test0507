package com.example.demo.message.resp;

public class VideoMessage extends Message{
	
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
