package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewControl {

	@GetMapping("/upload/view")
	public String toViewUpload() {
		return "upload";
	}
	
	@GetMapping("/upload/view/news")
	public String toViewUploadNews() {
		return "news";
	}
	
	@GetMapping("/send/view")
	public String toViewSend() {
		return "send";
	}
	
	@GetMapping("/temp/view")
	public String toViewTemp() {
		return "temp";
	}
	
	
}
