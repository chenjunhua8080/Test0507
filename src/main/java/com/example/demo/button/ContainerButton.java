package com.example.demo.button;

public class ContainerButton extends Button{
	
	
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}

	public ContainerButton() {
	}

	public ContainerButton(Button[] sub_button) {
		super();
		this.sub_button = sub_button;
	}

	
}
