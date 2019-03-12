package com.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService{
	
	@Autowired
	UserService userService;
		
	@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		com.usermanagement.model.User user = userService.getUserByMobileNumber(mobileNumber);
		return new User(
						user.getMobileNumber(),
						user.getPassword(),
						AuthorityUtils.createAuthorityList("read","write")
						);
		}
}
