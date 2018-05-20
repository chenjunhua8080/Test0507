package com.example.demo.temp;


public class TempItem {
	
	private String value;
	
	private String color;

	@Override
	public String toString() {
		return "TempItem [ value=" + value + ", color=" + color + "]";
	}

	public TempItem() {
	}
	
	public TempItem(String value, String color) {
		this.value = value;
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	

}
