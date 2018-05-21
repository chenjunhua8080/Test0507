package com.example.demo.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.Long2ShortDao;
import com.example.demo.dao.QrcodeDao;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;
import com.example.demo.qrcode.Long2Short;
import com.example.demo.qrcode.Qrcode;
import com.example.demo.qrcode.Scene;

import net.sf.json.JSONObject;

@RestController
public class QrcodeControl {

	@Autowired
	private TokenDao tokenDao;

	@Autowired
	private QrcodeDao qrcodeDao;
	
	@Autowired
	private Long2ShortDao shortDao;

	@PostMapping("/show/qrcode")
	public String mediaCount(HttpServletRequest request, Qrcode qrcode, Scene scene) throws Exception {
		String url = "";
		switch (qrcode.getAction_name()) {
		case "QR_SCENE":
			url = Api.qrcode_create.replace("TOKEN", tokenDao.findByIdMax().getValue());
			break;
		case "QR_STR_SCENE":
			url = Api.qrcode_create.replace("TOKEN", tokenDao.findByIdMax().getValue());
			break;
		case "QR_LIMIT_SCENE":
			url = Api.qrcode_create_forever.replace("TOKEN", tokenDao.findByIdMax().getValue());
			break;
		case "QR_LIMIT_STR_SCENE":
			url = Api.qrcode_create_forever.replace("TOKEN", tokenDao.findByIdMax().getValue());
			break;
		}
		qrcode.setAction_info(scene);
		JSONObject json = JSONObject.fromObject(qrcode);
		String param = json.toString();
		String result = HttpUtil.request(url, HttpMethod.POST, param);
		if (result.contains("ticket")) {
			JSONObject respJson = JSONObject.fromObject(result);
			qrcode.setUrl(respJson.getString("url"));
			qrcode.setTicket(respJson.getString("ticket"));
			qrcodeDao.save(qrcode);

			String filePath = request.getSession().getServletContext().getRealPath("/") + "down\\";
			url = Api.qrcode_show.replace("TICKET", qrcode.getTicket());
			String fileName = HttpUtil.downRequest(url, null, filePath);
			return "<img src=\"/down/"+fileName+"\">";
		}
		return result;
	}
	
	@GetMapping("/show/qrcode/{ticket}")
	public String show(HttpServletRequest request,@PathVariable String ticket) throws Exception{
		String filePath = request.getSession().getServletContext().getRealPath("/") + "down/";
		String url = Api.qrcode_show.replace("TICKET", ticket);
		String fileName = HttpUtil.downRequest(url, null, filePath);
		return fileName;
	}
	
	@PostMapping("/long2short")
	public String long2short(Long2Short long2Short) throws Exception{
		String url = Api.long2short.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String param = JSONObject.fromObject(long2Short).toString();
		String result = HttpUtil.request(url,HttpMethod.POST, param);
		if (result.contains("short_url")) {
			JSONObject respJson = JSONObject.fromObject(result);
			String shortUrl = respJson.getString("short_url");
			long2Short.setShort_url(shortUrl);
			Long2Short save = shortDao.save(long2Short);
			return save.toString();
		}
		return result;
	}
}
