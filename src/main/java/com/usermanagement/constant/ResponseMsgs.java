package com.usermanagement.constant;

public class ResponseMsgs {
	//invalid args
	public static final String EMAIL_INVALID_MSG = "Invalid email address";
	public static final String MOBILE_NUM_INVALID_MSG = "Invalid mobile number";
	public static final String GENDER_INVALID = "Invalid gender";
	public static final String OTP_MISMATCH = "OTP mismatched";
	
	//missing args
	public static final String NAME_MISSING_MSG = "Name must not be empty";
	public static final String EMAIL_MISSING_MSG = "Email address must not be empty";
	public static final String MOBILE_NUM_MISSING_MSG = "Mobile number must not be empty";
	public static final String PASSWORD_MISSING_MSG = "Password must not be empty";
	
	public static final String USER_ALREADY_EXIST = "Requested Email or Phone Number is already exist";
    public static final String USER_NOT_FOUND = "User doesn't exist";
	public static final String SOMETHING_WENT_WRONG = "Something went wrong";

    //success msgs
    public static final String REG_SUCCESS = "User has been registered successfully";
    public static final String LOGOUT_SUCCESS = "Logout successful";
    public static final String LOGIN_SUCCESS = "Login successful";
    public static final String REST_SERVICES_RUNNING = "Rest services are running";
    public static final String OTP_VERIFIED = "OTP verified";
    public static final String BANK_ADD_SUCCESS = "Bank details have been added successfully";
}
