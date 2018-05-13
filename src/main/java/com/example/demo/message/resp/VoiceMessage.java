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
public class VoiceMessage extends Message{
	
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
