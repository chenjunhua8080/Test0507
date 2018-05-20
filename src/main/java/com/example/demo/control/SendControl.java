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
		String type = send.getMsgtype();
		String param="{\r\n" + 
				" \"filter\":{\r\n" + 
				" \"is_to_all\":"+send.isIs_to_all()+",\r\n" + 
				" \"tag_id\":"+send.getTag_id()+"\r\n" + 
				" },\r\n" + 
				" \""+type+"\":{\r\n" + 
				" \"media_id\":\""+send.getContent()+"\"\r\n" + 
				" },\r\n" + 
				" \"msgtype\":\""+type+"\",\r\n" + 
				" \"send_ignore_reprint\":1\r\n" + 
				" }";
		if (type.equals("text")) {
			param=param.replace("media_id", "content");
		}
		String result = HttpUtil.request(url, HttpMethod.POST,
				param);
		JSONObject json = JSONObject.fromObject(result);
		if (json.getInt("errcode")==0) {
			if (result.contains("msg_id")) {
				send.setMsg_id(json.getString("msg_id"));
			}
			if (result.contains("msg_data_id")) {
				send.setMsg_data_id(json.getString("msg_data_id"));
			}
			Send respSend = sendDao.save(send);
			return respSend.toString();
		}
		return result;
	}
	
}
