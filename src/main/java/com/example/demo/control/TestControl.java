package com.example.demo.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ADao;
import com.example.demo.entity.A;
import com.example.demo.http.HttpUtil;

@RestController
public class TestControl {
	
	@Autowired
	private ADao aDao;
	
	@GetMapping("/down/a")
	public String downA() throws Exception {
		Map<String, Object> resp = HttpUtil.request();
		for (String key : resp.keySet()) {
			aDao.save(new A(key,resp.get(key).toString()));
		}
		return countA();
	}
	
	@GetMapping("/list/a")
	public String findAllA() throws Exception {
		StringBuilder sb=new StringBuilder();
		List<A> list = aDao.findAllByOrderById();
		for (A a : list) {
			if (!a.getText().contains("img")) {
				sb.append("<a href=\""+a.getHref()+"\" a>"+a.getText()+"</a><br/>");
			}
		}
		return sb.toString();
	}
	
	@GetMapping("/list/a/img")
	public String findAllAnotImg() throws Exception {
		StringBuilder sb=new StringBuilder();
		List<A> list = aDao.findAllByOrderByHref();
		for (A a : list) {
			if (a.getText().contains("img")) {
				sb.append("<a href=\""+a.getHref()+"\" a>"+a.getText()+"</a><br/>");
			}
		}
		return sb.toString();
	}
	
	@GetMapping("/clean/a")
	public String deleteAllA() throws Exception {
		aDao.deleteAll();
		return countA();
	}
	
	@GetMapping("/count/a")
	public String countA() throws Exception {
		return String.valueOf(aDao.count());
	}
}
