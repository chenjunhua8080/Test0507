package com.example.demo.message;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ReqMessageDao;
import com.example.demo.message.req.ImageMessage;
import com.example.demo.message.req.LinkMessage;
import com.example.demo.message.req.LocationMessage;
import com.example.demo.message.req.ShortVideoMessage;
import com.example.demo.message.req.TextMessage;
import com.example.demo.message.req.VideoMessage;
import com.example.demo.message.req.VoiceMessage;

import net.sf.json.JSONObject;

@Component
public class ReqMessageUtil {

	private static ReqMessageDao dao;

	@Autowired
	public void setDao(ReqMessageDao dao) {
		this.dao = dao;
	}

	public static void saveMessage(JSONObject json) {
		String type = json.getString("MsgType").toUpperCase();
		switch (type) {
		case MessageType.text:
			TextMessage textMessage = new TextMessage();
			textMessage.setFromUserName(json.getString("FromUserName"));
			textMessage.setToUserName(json.getString("ToUserName"));
			textMessage.setMsgType(json.getString("MsgType"));
			textMessage.setCreateTime(json.getLong("CreateTime"));
			textMessage.setMsgId(json.getLong("MsgId"));
			textMessage.setContent(json.getString("Content"));
			dao.save(textMessage);
			break;
		case MessageType.image:
			ImageMessage imageMessage = new ImageMessage();
			imageMessage.setFromUserName(json.getString("FromUserName"));
			imageMessage.setToUserName(json.getString("ToUserName"));
			imageMessage.setMsgType(json.getString("MsgType"));
			imageMessage.setCreateTime(json.getLong("CreateTime"));
			imageMessage.setMsgId(json.getLong("MsgId"));
			imageMessage.setMediaId(json.getString("MediaId"));
			imageMessage.setPicUrl(json.getString("PicUrl"));
			dao.save(imageMessage);
			break;
		case MessageType.voice:
			VoiceMessage voiceMessage = new VoiceMessage();
			voiceMessage.setFromUserName(json.getString("FromUserName"));
			voiceMessage.setToUserName(json.getString("ToUserName"));
			voiceMessage.setMsgType(json.getString("MsgType"));
			voiceMessage.setCreateTime(json.getLong("CreateTime"));
			voiceMessage.setMsgId(json.getLong("MsgId"));
			voiceMessage.setMediaId(json.getString("MediaId"));
			voiceMessage.setFormat(json.getString("Format"));
			voiceMessage.setRecognition(json.getString("Recognition"));
			dao.save(voiceMessage);
			break;
		case MessageType.video:
			VideoMessage videoMessage = new VideoMessage();
			videoMessage.setFromUserName(json.getString("FromUserName"));
			videoMessage.setToUserName(json.getString("ToUserName"));
			videoMessage.setMsgType(json.getString("MsgType"));
			videoMessage.setCreateTime(json.getLong("CreateTime"));
			videoMessage.setMsgId(json.getLong("MsgId"));
			videoMessage.setMediaId(json.getString("MediaId"));
			videoMessage.setThumbMediaId(json.getString("ThumbMediaId"));
			dao.save(videoMessage);
			break;
		case MessageType.location:
			LocationMessage locationMessage = new LocationMessage();
			locationMessage.setFromUserName(json.getString("FromUserName"));
			locationMessage.setToUserName(json.getString("ToUserName"));
			locationMessage.setMsgType(json.getString("MsgType"));
			locationMessage.setCreateTime(json.getLong("CreateTime"));
			locationMessage.setMsgId(json.getLong("MsgId"));
			locationMessage.setLocation_X(json.getString("Location_X"));
			locationMessage.setLocation_Y(json.getString("Location_Y"));
			locationMessage.setScale(json.getString("Scale"));
			locationMessage.setLabel(json.getString("Label"));
			dao.save(locationMessage);
			break;
		case MessageType.link:
			LinkMessage linkMessage = new LinkMessage();
			linkMessage.setFromUserName(json.getString("FromUserName"));
			linkMessage.setToUserName(json.getString("ToUserName"));
			linkMessage.setMsgType(json.getString("MsgType"));
			linkMessage.setCreateTime(json.getLong("CreateTime"));
			linkMessage.setMsgId(json.getLong("MsgId"));
			linkMessage.setTitle(json.getString("Title"));
			linkMessage.setDescription(json.getString("Description"));
			linkMessage.setUrl(json.getString("Url"));
			dao.save(linkMessage);
			break;
		case MessageType.short_video:
			ShortVideoMessage shortVideoMessage = new ShortVideoMessage();
			shortVideoMessage.setFromUserName(json.getString("FromUserName"));
			shortVideoMessage.setToUserName(json.getString("ToUserName"));
			shortVideoMessage.setMsgType(json.getString("MsgType"));
			shortVideoMessage.setCreateTime(json.getLong("CreateTime"));
			shortVideoMessage.setMsgId(json.getLong("MsgId"));
			shortVideoMessage.setMediaId(json.getString("MediaId"));
			shortVideoMessage.setThumbMediaId(json.getString("ThumbMediaId"));
			dao.save(shortVideoMessage);
			break;
		}
	}

}
