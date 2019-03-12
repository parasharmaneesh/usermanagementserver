package com.usermanagement.response;

public class LoginResponse {
	private long accessToken;
	private String message;
	private int status;
	public long getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(long accessToken) {
		this.accessToken = accessToken;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
