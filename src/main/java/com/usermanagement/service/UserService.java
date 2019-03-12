package com.usermanagement.service;

import java.security.Principal;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.usermanagement.constant.ResponseMsgs;
import com.usermanagement.exception.OTPMismatchException;
import com.usermanagement.exception.UserAlreadyExistException;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.request.UserRegRequest;
import com.usermanagement.response.DefaultResponse;
import com.usermanagement.response.ProfileInfoResponse;

@Service
@Configuration
public class UserService {
	@Autowired
	ISmsService smsService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	TokenStore tokenStore;

	@Transactional
	public void existsByEmailOrMobileNumber(String email, String mobileNumber) {
		boolean doesUserExist = false;
		if (email == null) {
			doesUserExist = userRepo.existsByMobileNumber(mobileNumber);
		} else {
			doesUserExist = userRepo.existsByEmailOrMobileNumber(email, mobileNumber);
		}
		if (doesUserExist) {

			throw new UserAlreadyExistException();
		}
	}

	@Transactional
	public DefaultResponse createUser(UserRegRequest request) {

		String email = request.getEmail();
		if (StringUtils.isEmpty(email)) {
			email = null;
			request.setEmail(null);
			System.out.println("String is not empty");
		}

		// check if user already exist
		existsByEmailOrMobileNumber(email, request.getMobileNumber());

		// Create new user
		User user = modelMapper.map(request, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setOTP(String.valueOf(generateRandomDigits()));
		userRepo.save(user);

		generateOTPUsingMobileNumber(user.getMobileNumber(), user.getOTP());

		DefaultResponse response = new DefaultResponse();
		response.setTimeStamp(new Date());
		response.setMessage(ResponseMsgs.REG_SUCCESS);
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

	@Transactional
	public ProfileInfoResponse getProfileInfo(Principal principal) {
		User user = userRepo.findByMobileNumber(principal.getName());
		ProfileInfoResponse response = new ProfileInfoResponse();
		BeanUtils.copyProperties(user, response);
		return response;
	}

	public DefaultResponse login(Principal p) {
		DefaultResponse response = new DefaultResponse();
		response.setTimeStamp(new Date());
		response.setMessage(p.getName());
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

	public DefaultResponse logout(OAuth2Authentication auth) {
		OAuth2AccessToken accessToken = tokenStore.getAccessToken(auth);
		OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
		tokenStore.removeAccessToken(accessToken);
		tokenStore.removeRefreshToken(refreshToken);

		DefaultResponse response = new DefaultResponse();
		response.setTimeStamp(new Date());
		response.setMessage(ResponseMsgs.LOGOUT_SUCCESS);
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

	@Transactional
	public User getUserByMobileNumber(String mobileNumber) {
		User user = userRepo.findByMobileNumber(mobileNumber);
		if (user == null)
			throw new UserNotFoundException(ResponseMsgs.USER_NOT_FOUND);
		else {
			return user;
		}
	}

	public DefaultResponse test() {
		DefaultResponse response = new DefaultResponse();
		response.setTimeStamp(new Date());
		response.setMessage(ResponseMsgs.REST_SERVICES_RUNNING);
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

	public void generateOTPUsingMobileNumber(String mobileNumber, String OTP) {
		smsService.sendOTP(mobileNumber, OTP);
	}

	public DefaultResponse verifyOTPUsingMobile(String mobileNumber, String OTP) {
		User user = getUserByMobileNumber(mobileNumber);
		if (user.getOTP().equals(OTP)) {
			user.setIsMobileVerified(true);
			user.setOTP(null);
			userRepo.save(user);
		} else {
			throw new OTPMismatchException(ResponseMsgs.OTP_MISMATCH);
		}
		DefaultResponse response = new DefaultResponse();
		response.setTimeStamp(new Date());
		response.setMessage(ResponseMsgs.OTP_VERIFIED);
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

	private int generateRandomDigits() {
		int min = 1000;
		int max = 9999;
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
}
