package com.usermanagement.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserBalance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private BigDecimal cashbackInPercent = new BigDecimal("0");
	private BigDecimal totalBalance = new BigDecimal("0");
	private BigDecimal unlockedBalance = new BigDecimal("0");
	
//	@OneToOne(mappedBy = "userBalance")
//	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCashbackInPercent() {
		return cashbackInPercent;
	}

	public void setCashbackInPercent(BigDecimal cashbackInPercent) {
		this.cashbackInPercent = cashbackInPercent;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	public BigDecimal getUnlockedBalance() {
		return unlockedBalance;
	}

	public void setUnlockedBalance(BigDecimal unlockedBalance) {
		this.unlockedBalance = unlockedBalance;
	}

//	public User getUser() {
//		return user;
//	}

//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
}
