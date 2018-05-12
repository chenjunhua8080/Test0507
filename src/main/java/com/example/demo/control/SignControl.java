package com.example.demo.control;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SignParam;
import com.example.demo.message.MessageUtil;
import com.example.demo.sgin.Signature;
import com.example.demo.xml.XmlUtil;

@RestController
public class SignControl {

	@Autowired
	private Signature signature;
	
	/**
	 * 
	 * @param signParam
	 * @param request
	 * @return
	 */
	@GetMapping("/checkSignature")
	public String checkSignature(SignParam signParam) {
		System.out.println("checkSignature...");
		if (signature.isPass(signParam)) {
			System.out.println("sign pass");
			return signParam.getEchostr();
		}
		return null;
	}
	/**
	 * 接收普通消息<br/>
	 * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。<br/>
	 * @param signParam
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/checkSignature")
	public String message(HttpServletRequest request) throws Exception {
		System.out.println("收到消息/事件...");
		Map<String, String> map = XmlUtil.parseXml(request);
		String resp = MessageUtil.build(map);
		return resp;
	}
}
