package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	public boolean existsByEmailOrMobileNumber(String email, String mobileNumber);
	public User findByMobileNumber(String mobileNumber);
	public User findByMobileNumberAndPassword(String mobileNumber, String password);
	public User findById(long id);
	public boolean existsByMobileNumber(String mobileNumber);
}
