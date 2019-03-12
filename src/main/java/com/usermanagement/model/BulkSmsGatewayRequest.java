package com.usermanagement.model;

import org.springframework.stereotype.Component;

@Component
public class BulkSmsGatewayRequest {
	private String basePath = "http://login.bulksmsgateway.in/sendmessage.php";
	private String preParams = "user=PRICECLIQ33&password=pricecliq@33&sender=PRCCLQ&type=3";
	private String mobile;
	private String message;
	public String getSMSEndpoint(String mobile, String message) {
		this.mobile = mobile;
		this.message = message;
		String SMSEndpoint = basePath + "?" + preParams + "&mobile=" + mobile + "&message=" + message;
		return SMSEndpoint;
	}
	
}
