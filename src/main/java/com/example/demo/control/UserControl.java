package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;

@RestController
public class UserControl {

	@Autowired
	private TokenDao tokenDao;
	
	@GetMapping("/list/black")
	public String blackList() throws Exception {
		String url = Api.black_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST, "{\"begin_openid\":\"\"}");
		return result;
	}
	
	@GetMapping("/rollback/black")
	public String rollback() throws Exception {
		String url = Api.set_black_rollback.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST, "{\"openid_list\":[\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\"]}");
		return result;
	}
	
}
