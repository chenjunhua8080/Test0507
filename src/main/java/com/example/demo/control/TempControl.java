package com.example.demo.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.TempDao;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;
import com.example.demo.temp.Temp;
import com.example.demo.temp.TempData;
import com.example.demo.temp.TempItem;

import net.sf.json.JSONObject;

@RestController
public class TempControl {
	

	@Autowired
	private TokenDao tokenDao;
	
	@Autowired
	private TempDao tempDao;

	@GetMapping("/set/temp/{id1}/{id2}")
	public String temp_set_industry(@PathVariable int id1,@PathVariable int id2) throws Exception {
		String url = Api.temp_set_industry.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\r\n" + 
				"\"industry_id1\":\""+id1+"\",\r\n" + 
				"\"industry_id2\":\""+id2+"\"\r\n" + 
				"}");
		return result;
	}
	
	@GetMapping("/get/temp")
	public String temp_get_industry() throws Exception {
		String url = Api.temp_get_industry.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.GET,null);
		return result;
	}
	
	@GetMapping("/list/temp")
	public String temp_list() throws Exception {
		String url = Api.temp_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.GET,null);
		return result;
	}
	
	@GetMapping("/delete/temp/{tempid}")
	public String temp_list(@PathVariable int tempid) throws Exception {
		String url = Api.temp_delete.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\r\n" + 
				"\"template_id\" : \""+tempid+"\"\r\n" + 
				"}");
		return result;
	}
	
	@PostMapping("/send/temp")
	public String temp_send(Temp temp,@RequestParam Map<String,String> map) throws Exception {
		String url = Api.temp_send.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
//		TempData data=new TempData();
		TempItem f = new TempItem(map.get("f.value"), map.get("f.color"));
		TempItem k1 = new TempItem(map.get("k1.value"), map.get("k1.color"));
		TempItem k2 = new TempItem(map.get("k2.value"), map.get("k2.color"));
		TempItem r = new TempItem(map.get("r.value"), map.get("r.color"));
		TempData data=new TempData(f,k1,k2,r);
		temp.setData(data);
		String param=JSONObject.fromObject(temp).toString();
		String result = HttpUtil.request(url, HttpMethod.POST,param
				/*"{ \r\n" + 
				"\"touser\":\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\", \r\n" + 
				"\"template_id\":\"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY\", \r\n" + 
				"\"url\":\"http://weixin.qq.com/download\", \r\n" + 
				"\"miniprogram\":{ \r\n" + 
				"\"appid\":\"xiaochengxuappid12345\", \r\n" + 
				"\"pagepath\":\"index?foo=bar\" \r\n" + 
				"}, \r\n" + 
				"\"data\":{ \r\n" + 
				".......... \r\n" + 
				"} \r\n" + 
				"} "*/
				);
		if (result.contains("msgid")) {
			temp.setMsgid(JSONObject.fromObject(result).getString("msgid"));
			tempDao.save(temp);
		}
		return result;
	}
	
}
