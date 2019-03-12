package com.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
	Optional<Account> findByUsername(String username);
}
