package com.example.demo.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.TokenDao;
import com.example.demo.entity.Token;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;

import net.sf.json.JSONObject;

@RestController
public class TokenControl {
	
	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appsecret}")
	private String appsecret;
	@Autowired
	private TokenDao tokenDao;

	@GetMapping("/getToken")
	public String getToken() throws Exception {
		String url=Api.access_token.replace("APPID", appid).replace("APPSECRET", appsecret);
		String result=HttpUtil.request(url, HttpMethod.GET, null);
		if (!result.contains("errcode")) {
			JSONObject jsonObject=JSONObject.fromObject(result);
			Token token=new Token(jsonObject.getString("access_token"), jsonObject.getInt("expires_in"), new Date());
			return tokenDao.save(token).toString();
		}
		return result;
	}
	
}
