package com.example.demo.sgin;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entity.SignParam;

@Component("Signature")
public class Signature {

	@Value("${wechat.tokenKey}")
	private String token;
	
	public boolean isPass(SignParam param) {
		
		String[] arr=new String[] {token,param.getTimestamp(),param.getNonce()};
		Arrays.sort(arr);
		
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		if (DigestUtils.sha1Hex(sb.toString()).equals(param.getSignature())) {
			return true;
		}
		
		return false;
	}
	
}
