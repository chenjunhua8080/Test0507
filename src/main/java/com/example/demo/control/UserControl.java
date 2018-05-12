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
	
	@GetMapping("/set/black")
	public String setBlack() throws Exception {
		String url = Api.set_black.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST, "{\"openid_list\":[\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\"]}");
		return result;
	}
	
	@GetMapping("/rollback/black")
	public String rollBlack() throws Exception {
		String url = Api.set_black_rollback.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST, "{\"openid_list\":[\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\"]}");
		return result;
	}
	
	@GetMapping("/set/remark")
	public String setRemark() throws Exception {
		String url = Api.set_remark.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST, "{\"openid\":\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\",\"remark\":\"90后的小天才\"}");
		return result;
	}
	
	@GetMapping("/get/user")
	public String userInfo() throws Exception {
		String url = Api.user_info.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue()).replace("OPENID", "ouTbH0aDYqhXvpwhcJ3i5sHfi8JY");
		String result = HttpUtil.request(url, HttpMethod.GET,null);
		return result;
	}
	
	@GetMapping("/get/users")
	public String usersInfo() throws Exception {
		String url = Api.users_info.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,"{\r\n" + 
				"\"user_list\": [\r\n" + 
				"{ \"openid\": \"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\", \r\n" + 
				"\"lang\": \"zh_CN\"\r\n" + 
				"}, \r\n" + 
				"{\r\n" + 
				"\"openid\": \"ouTbH0SnzBFvIxW7OnqTlKvOW5Pw\", \r\n" + 
				"\"lang\": \"zh_CN\"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"");
		return result;
	}
	
	@GetMapping("/list/user")
	public String userList() throws Exception {
		String url = Api.user_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue()).replace("next_openid", "");
		String result = HttpUtil.request(url, HttpMethod.GET,null);
		return result;
	}
	
}
