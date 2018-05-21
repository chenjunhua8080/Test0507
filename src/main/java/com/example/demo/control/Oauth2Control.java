package com.example.demo.control;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.Oauth2TokenDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;
import com.example.demo.oauth2.Oauth2Token;
import com.example.demo.oauth2.UserInfo;

import net.sf.json.JSONObject;

@RestController
public class Oauth2Control {

	@Autowired
	private Oauth2TokenDao tokenDao;
	@Autowired
	private UserInfoDao userDao;
	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appsecret}")
	private String appsecret;
	
	@GetMapping("/oauth2/check/{token}/{openid}")
	public String check(@PathVariable String token,@PathVariable String openid) throws Exception {
		String url = Api.oauth2_check.replace("ACCESS_TOKEN", token)
				.replace("OPENID", openid);
		String result = HttpUtil.request(url,HttpMethod.GET,null);
		return result;
	}

	@GetMapping("/oauth2/index")
	public void index(HttpServletResponse response) throws Exception {
		String url = Api.oauth2_connect.replace("APPID", appid)
				.replace("REDIRECT_URI", "http://cjh.nat300.top/oauth2/redirect")
				.replace("SCOPE", "snsapi_userinfo")
				.replace("STATE", "book");
		response.sendRedirect(url);
	}

	@GetMapping("/oauth2/redirect")
	public String redirect_uri(@RequestParam Map<String, String> map) throws Exception {
		String code=map.get("code");
		String url = Api.oauth2_access_token.replace("APPID", appid)
						.replace("SECRET", appsecret)
						.replace("CODE", code);
		String result = HttpUtil.request(url,HttpMethod.GET,null);
		if (result.contains("7200")) {
			JSONObject json = JSONObject.fromObject(result);
			Oauth2Token token = (Oauth2Token) JSONObject.toBean(json, Oauth2Token.class);
			token.setCreateDate(new Date());
			Oauth2Token save = tokenDao.save(token);
//			return save.toString();
//			刷新refresh_token有效期为30天
			String refresh_token = oauth2_refresh_token(save.getRefresh_token());
//			return save.toString()+"<br/><br/><br/>"+refresh_token;
//			获取基本信息
			String userinfo = oauth2_userinfo(token.getAccess_token(), token.getOpenid());
			if (userinfo.contains("nickname")) {
				JSONObject jsonUser = JSONObject.fromObject(userinfo);
				UserInfo user = (UserInfo) JSONObject.toBean(jsonUser, UserInfo.class);
				userDao.save(user);
				String headimgurl = user.getHeadimgurl();
				if (headimgurl!=null) {
					headimgurl=headimgurl.replace("\\/", "/");
					user.setHeadimgurl(headimgurl);
				}
				return "openid:"+user.getOpenid()+"<br/>"+
				"昵称:"+user.getNickname()+"<br/>"+
				"性别:"+(user.getSex()==1?"男":"女")+"<br/>"+
				"位区:"+user.getCountry()+user.getProvince()+user.getCity()+"<br/>"+
				"头像:<br/>"+
				"<img src=\""+headimgurl+"\">";
			}	
			return userinfo;
		}
		return map.toString();
	}
	
	public String oauth2_refresh_token(String REFRESH_TOKEN) throws Exception {
		String url = Api.oauth2_refresh_token.replace("APPID", appid)
						.replace("REFRESH_TOKEN", REFRESH_TOKEN);
		String result = HttpUtil.request(url,HttpMethod.GET,null);
		if (result.contains("7200")) {
			JSONObject json = JSONObject.fromObject(result);
			Oauth2Token token = (Oauth2Token) JSONObject.toBean(json, Oauth2Token.class);
			token.setCreateDate(new Date());
			Oauth2Token save = tokenDao.save(token);
			return save.toString();
		}
		return result;
	}
	public String oauth2_userinfo(String oauth2token,String openid) throws Exception {
		String url = Api.oauth2_userinfo.replace("OPENID", openid)
						.replace("ACCESS_TOKEN", oauth2token);
		String result = HttpUtil.request(url,HttpMethod.GET,null);
		return result;
	}

}
