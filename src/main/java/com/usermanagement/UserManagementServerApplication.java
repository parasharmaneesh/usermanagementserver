package com.usermanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@ComponentScan({ "com.usermanagement" })
@EntityScan({ "com.usermanagement.model" })
@EnableJpaRepositories({ "com.usermanagement.repository" })
@EnableAuthorizationServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserManagementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServerApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMappr() {
		return new ModelMapper();
	}
}
