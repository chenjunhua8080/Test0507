package com.example.demo.button;

public class Button {
	
	private String name;
	
	private String type;

	private int location;
	
	private int container;
	
	
	public Button() {
	}

	public Button(String name, String type, int location, int container) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.container = container;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getContainer() {
		return container;
	}

	public void setContainer(int container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return "Button [name=" + name + ", type=" + type + ", location=" + location + ", container=" + container + "]";
	}
}
