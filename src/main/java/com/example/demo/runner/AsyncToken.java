package com.example.demo.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.demo.control.TokenControl;
import com.example.demo.dao.TokenDao;
import com.example.demo.entity.Token;

//@Component
public class AsyncToken {

	@Autowired
	private TokenControl tokenControl;

	@Autowired
	private TokenDao tokenDao;
	
	@Async
	public void getToken() throws Exception {
		Token token = tokenDao.findByIdMax();
		if (((new Date().getTime())-(token.getCreateDate().getTime()))>60*60*1000) {
			tokenControl.getToken();
			System.out.println("更新token...");
		}
		Thread.sleep(60*1000);
	}
	
}
