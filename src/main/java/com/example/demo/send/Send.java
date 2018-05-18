package com.example.demo.send;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Send {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean is_to_all;
	private int tag_id;
	private String msgtype;
	private String content;
	
	private String msg_id;
	private String msg_data_id;


	@Override
	public String toString() {
		return "Send [id=" + id + ", is_to_all=" + is_to_all + ", tag_id=" + tag_id + ", msgtype=" + msgtype
				+ ", content=" + content + ", msg_id=" + msg_id + ", msg_data_id=" + msg_data_id + "]";
	}

	public Send(boolean is_to_all, int tag_id, String msgtype, String content) {
		this.is_to_all = is_to_all;
		this.tag_id = tag_id;
		this.msgtype = msgtype;
		this.content = content;
	}

	public Send() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIs_to_all() {
		return is_to_all;
	}

	public void setIs_to_all(boolean is_to_all) {
		this.is_to_all = is_to_all;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_data_id() {
		return msg_data_id;
	}

	public void setMsg_data_id(String msg_data_id) {
		this.msg_data_id = msg_data_id;
	}
	
	

}
