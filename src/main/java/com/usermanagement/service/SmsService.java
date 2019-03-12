package com.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usermanagement.model.BulkSmsGatewayRequest;

@Service
@EnableAsync
public class SmsService implements ISmsService{
	
	@Autowired
	BulkSmsGatewayRequest bulkSmsGatewayRequest;
	
	@Override
	@Async
	public void sendOTP(String mobileNumber,  String OTP) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		//BulkSmsGatewayRequest bulkSmsGatewayRequest = context.getBean(BulkSmsGatewayRequest.class);
		String SMSEndpoint = bulkSmsGatewayRequest.getSMSEndpoint(mobileNumber, OTP);
		//restTemplate.getForObject(SMSEndpoint,Object.class);
		System.out.println("Sms sent");
	}
	
}
