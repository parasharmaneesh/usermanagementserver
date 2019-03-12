package com.usermanagement.exception;

public class OTPMismatchException extends RuntimeException{

	private static final long serialVersionUID = -6375407708146532004L;
	private String message;

	public OTPMismatchException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
