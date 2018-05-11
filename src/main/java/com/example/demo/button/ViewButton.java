package com.example.demo.button;

public class ViewButton extends Button{
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	public ViewButton() {
		super();
	}

	public ViewButton(String name, String type, int location, int container, String url) {
		super(name, type, location, container);
		this.url = url;
	}

	
	
}
