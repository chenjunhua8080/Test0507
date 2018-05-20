package com.example.demo.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.custom.Custom;
import com.example.demo.dao.CustomDao;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;

import net.sf.json.JSONObject;

@RestController
public class CustomControl {

	@Autowired
	private TokenDao tokenDao;
	@Autowired
	private CustomDao customDao;

	@GetMapping("/add/custom/{kf_account}/{nickname}/{password}")
	public String custom_add(Custom custom) throws Exception {
		String url = Api.custom_add.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		JSONObject json = JSONObject.fromObject(custom);
		String param = json.toString();
		String result = HttpUtil.request(url, HttpMethod.POST, param);
		if (result.contains("ok")) {
			return customDao.save(custom).toString();
		}
		return result;
	}

	@GetMapping("/update/custom/{kf_account}/{nickname}/{password}")
	public String custom_update(Custom custom) throws Exception {
		String url = Api.custom_update.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		JSONObject json = JSONObject.fromObject(custom);
		String param = json.toString();
		String result = HttpUtil.request(url, HttpMethod.POST, param);
		if (result.contains("ok")) {
			return customDao.save(custom).toString();
		}
		return result;
	}

	@GetMapping("/delete/custom/{kf_account}/{nickname}/{password}")
	public String custom_delete(Custom custom) throws Exception {
		String url = Api.custom_delete.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		JSONObject json = JSONObject.fromObject(custom);
		String param = json.toString();
		String result = HttpUtil.request(url, HttpMethod.POST, param);
		return result;
	}

	@GetMapping("/list/custom")
	public String custom_list() throws Exception {
		String url = Api.custom_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.GET, null);
		return result;
	}

	@PostMapping("/send/custom")
	public String custom_send(@RequestParam Map<String, String> map) throws Exception {
		String url = Api.custom_send.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\r\n" + "\"touser\":\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\",\r\n" + "\"msgtype\":\"text\",\r\n"
						+ "\"text\":\r\n" + "{\r\n" + "\"content\":\"" + map.get("content") + "\"\r\n" + "}\r\n" + "}");
		return result;
	}

	@GetMapping("/custom/typing")
	public String custom_typing() throws Exception {
		String url = Api.custom_typing.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{ \"touser\":\"ouTbH0aDYqhXvpwhcJ3i5sHfi8JY\", \"command\":\"Typing\"}");
		return result;
	}

}
