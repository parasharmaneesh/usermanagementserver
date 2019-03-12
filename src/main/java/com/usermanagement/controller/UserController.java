package com.usermanagement.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.request.UserRegRequest;
import com.usermanagement.response.ProfileInfoResponse;
import com.usermanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public Object createUser(@Valid @RequestBody UserRegRequest userRegRequest) {
		return userService.createUser(userRegRequest);
	}
	
	@GetMapping("/getProfile")
	public ProfileInfoResponse getProfileInfo(Principal principal) {
		return userService.getProfileInfo(principal);
	}
	
	@GetMapping("/logout")
	public Object logout(OAuth2Authentication auth) {
		return userService.logout(auth);
	}
	
	@GetMapping("/test")
	public Object test() {
		return userService.test();
	}
		 
	@GetMapping("/verifyOTP")
	public Object verifyOTPUsingMobile(String mobileNumber, String OTP) {
		return userService.verifyOTPUsingMobile(mobileNumber, OTP);
	}
	
}
