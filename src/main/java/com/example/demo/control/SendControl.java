package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.SendDao;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;
import com.example.demo.send.Send;

import net.sf.json.JSONObject;

@RestController
public class SendControl {
	
	@Autowired
	private TokenDao tokenDao;
	@Autowired
	private SendDao sendDao;

	@PostMapping("/send")
	public String send(Send send) throws Exception {
		String url = Api.send_message.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\r\n" + 
				" \"filter\":{\r\n" + 
				" \"is_to_all\":"+send.isIs_to_all()+",\r\n" + 
				" \"tag_id\":"+send.getTag_id()+"\r\n" + 
				" },\r\n" + 
				" \"mpnews\":{\r\n" + 
				" \"media_id\":\""+send.getContent()+"\"\r\n" + 
				" },\r\n" + 
				" \"msgtype\":\""+send.getMsgtype()+"\",\r\n" + 
				" \"send_ignore_reprint\":1\r\n" + 
				" }");
		if (result.contains("msg_id")) {
			JSONObject json = JSONObject.fromObject(result);
			send.setMsg_id(json.getString("msg_id"));
			send.setMsg_data_id(json.getString("msg_data_id"));
			Send respSend = sendDao.save(send);
			return respSend.toString();
		}
		return result;
	}
	
}
