package com.example.demo.entity;

public class SignParam {
	
	private String signature ;
	private String timestamp ;
	private String nonce ;
	private String echostr ;
	public SignParam() {
	}
	public SignParam(String signature, String timestamp, String nonce) {
		super();
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
	}
	public SignParam(String signature, String timestamp, String nonce, String echostr) {
		super();
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.echostr = echostr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	
	
	

}
