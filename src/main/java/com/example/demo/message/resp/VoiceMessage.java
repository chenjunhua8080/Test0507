package com.example.demo.message.resp;

public class VoiceMessage extends Message{
	
	private Voice Voice;

	public VoiceMessage() {
	}

	public VoiceMessage(String toUserName, String fromUserName, long createTime, String msgType,
			com.example.demo.message.resp.Voice voice) {
		super(toUserName, fromUserName, createTime, msgType);
		Voice = voice;
	}

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}

	

}
