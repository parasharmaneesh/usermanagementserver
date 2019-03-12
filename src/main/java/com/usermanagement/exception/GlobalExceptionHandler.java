package com.usermanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usermanagement.constant.ResponseMsgs;
import com.usermanagement.response.DefaultResponse;

@RestControllerAdvice
public class GlobalExceptionHandler{

	//Default RequestBody validation exception handling
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public DefaultResponse invalidRequest(MethodArgumentNotValidException ex) {
		FieldError fieldError = ex.getBindingResult().getFieldError();
		String defaultMsg = (fieldError !=null) ? fieldError.getDefaultMessage() : ResponseMsgs.SOMETHING_WENT_WRONG;
		DefaultResponse response = new DefaultResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(defaultMsg);
		response.setTimeStamp(new Date());
		return response;
    }
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public DefaultResponse handleUserAlreadyExistException(UserAlreadyExistException ex) {
		DefaultResponse response = new DefaultResponse();
		response.setStatus(HttpStatus.CONFLICT.value());
		response.setMessage(ResponseMsgs.USER_ALREADY_EXIST);
		response.setTimeStamp(new Date());
		return response;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public DefaultResponse handleUserNotFoundException(UserNotFoundException ex) {
		DefaultResponse response = new DefaultResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(new Date());
		return response;
	}
	
	@ExceptionHandler(BadRequestException.class)
	public DefaultResponse handleBadRequestException(BadRequestException ex) {
		DefaultResponse response = new DefaultResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(new Date());
		return response;
	}
	
	@ExceptionHandler(OTPMismatchException.class)
	public DefaultResponse handleOTPMismatchException(OTPMismatchException ex) {
		DefaultResponse response = new DefaultResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(new Date());
		return response;
	}
	
	//default exception handler
//	@ExceptionHandler(Exception.class)
//	public DefaultResponse handleError(Exception req) {
//		DefaultResponse response = new DefaultResponse();
//		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//		response.setMessage(ResponseMsgs.SOMETHING_WENT_WRONG);
//		response.setTimeStamp(new Date());
//		return response;
//	}
}
