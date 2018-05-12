package com.example.demo.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.control.TokenControl;
import com.example.demo.dao.TokenDao;
import com.example.demo.entity.Token;


@Component("TokenRunner")
public class TokenRunner implements ApplicationRunner{
	
	@Autowired
	private TokenControl tokenControl;

	@Autowired
	private TokenDao tokenDao;
	
	Thread thread=new Thread(new Runnable() {
		@Override
		public void run() {
			while(true) {
				try {
					Token token = tokenDao.findByIdMax();
					if (token==null) {
						tokenControl.getToken();
						System.out.println("更新token...");
					}else {
						long time = new Date().getTime()-token.getCreateDate().getTime();
						if (time>60*60*1000) {
							tokenControl.getToken();
							System.out.println("更新token...");
						}
					}
					Thread.sleep(30*60*1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	});


	@Override
	public void run(ApplicationArguments args) throws Exception {
		thread.start();
	}

}
