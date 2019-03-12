package com.usermanagement.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.usermanagement.annotation.EnumValue;
import com.usermanagement.annotation.MobileNumber;
import com.usermanagement.constant.ResponseMsgs;
import com.usermanagement.model.Gender;

public class UserRegRequest {
	@NotNull(message = ResponseMsgs.NAME_MISSING_MSG)
	private String name;
	
	@NotNull(message = ResponseMsgs.MOBILE_NUM_MISSING_MSG)
	@MobileNumber(message = ResponseMsgs.MOBILE_NUM_INVALID_MSG)
	private String mobileNumber;
	
	//@NotBlank(message = ResponseMsgs.EMAIL_MISSING_MSG)
	@Email(message = ResponseMsgs.EMAIL_INVALID_MSG)
	private String email;

	@NotNull(message = ResponseMsgs.PASSWORD_MISSING_MSG)
	private String password;
	
	@EnumValue(enumClass = Gender.class, message = ResponseMsgs.GENDER_INVALID)
	private String gender = Gender.UNDEFINED.toString();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
