package com.usermanagement.response;

import com.usermanagement.model.UserBalance;
import com.usermanagement.model.UserType;

public class ProfileInfoResponse {
	private String name;
	private String mobileNumber;
	private String email;
	private UserType userType;
	private Boolean isMobileVerified;
	private UserBalance userBalance;
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
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Boolean getIsMobileVerified() {
		return isMobileVerified;
	}
	public void setIsMobileVerified(Boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}
	public UserBalance getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(UserBalance userBalance) {
		this.userBalance = userBalance;
	}
	
}
