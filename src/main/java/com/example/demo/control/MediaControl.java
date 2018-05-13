package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;

@RestController
public class MediaControl {

	@Autowired
	private TokenDao tokenDao;
	
	@GetMapping("/count/media")
	public String mediaCount() throws Exception {
		String url = Api.media_count.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.GET,null);
		return result;
	}
	
	@GetMapping("/list/media/{type}")
	public String mediaList(@PathVariable String type) throws Exception {
		String url = Api.media_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,"{\"type\":\""+type+"\",\"offset\":\"0\",\"count\":\"10\"}");
		return result;
	}
	
}
