package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewControl {

	@GetMapping("/upload/view")
	public String toViewUpload() {
		return "upload";
	}
	
}
