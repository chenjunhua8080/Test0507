package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.button.ButtonUtil;
import com.example.demo.dao.TokenDao;
import com.example.demo.entity.Token;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;

@RestController
public class MenuControl {

	@Autowired
	private TokenDao tokenDao;
	
	@GetMapping("/create/menu")
	public String build() throws Exception {
		Token token = tokenDao.findByIdMax();
		String url = Api.menu_create.replace("ACCESS_TOKEN", token.getValue());
		String btnBuild = ButtonUtil.build();
		String result = HttpUtil.request(url, HttpMethod.POST, btnBuild);
		return result;
	}
	
	@GetMapping("/get/menu")
	public String get() throws Exception {
		Token token = tokenDao.findByIdMax();
		String url = Api.menu_get.replace("ACCESS_TOKEN", token.getValue());
		String result = HttpUtil.request(url, HttpMethod.GET, null);
		return result;
	}
	
	@GetMapping("/delete/menu")
	public String delete() throws Exception {
		Token token = tokenDao.findByIdMax();
		String url = Api.menu_delete.replace("ACCESS_TOKEN", token.getValue());
		String result = HttpUtil.request(url, HttpMethod.GET, null);
		return result;
	}
}
