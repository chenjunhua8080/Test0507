package com.example.demo.message.resp;

public class Message {
	
	private String ToUserName;
	private String FromUserName;
	private Integer CreateTime;
	private String MsgType;
	private Integer MsgId;
	public Message() {
	}
	public Message(String toUserName, String fromUserName, Integer createTime, String msgType, Integer msgId) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		MsgId = msgId;
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Integer getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public Integer getMsgId() {
		return MsgId;
	}
	public void setMsgId(Integer msgId) {
		MsgId = msgId;
	}
	
	

}
