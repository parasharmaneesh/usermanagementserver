package com.usermanagement.exception;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class OauthReponseAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof DefaultOAuth2AccessToken) {
			LinkedHashMap<String, Object> customResponse = new LinkedHashMap<>();
			DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;
			customResponse.put(token.ACCESS_TOKEN, token.getValue());
			customResponse.put(token.REFRESH_TOKEN, token.getRefreshToken().getValue());
			customResponse.put("status", HttpStatus.OK.value());
			return customResponse;
		} else {
			return body;
		}
	}

}
