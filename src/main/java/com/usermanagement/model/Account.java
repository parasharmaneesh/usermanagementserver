package com.usermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String username;
	private String password;
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account() {
		
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
}
