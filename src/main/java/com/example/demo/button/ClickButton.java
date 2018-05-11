package com.example.demo.button;

public class ClickButton extends Button{

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	public ClickButton() {
	}

	public ClickButton(String name, String type, int location, int container, String key) {
		super(name, type, location, container);
		this.key = key;
	}

	@Override
	public String toString() {
		return "ClickButton [key=" + key + "]";
	}
	
	
	
}
