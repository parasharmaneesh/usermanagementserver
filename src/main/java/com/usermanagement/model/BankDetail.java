package com.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bank_details")
public class BankDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	private String accountName;
	private String IFSC;
	private String accountNum;
	private String panNum;
	private String registeredMobileNumber;
	private String bankName; 
	private String paymemtMethodName; 
	private boolean isVerified;
	
	@ManyToOne()
    @JoinColumn()
	@JsonIgnore
    private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getaccountNum() {
		return accountNum;
	}
	public void setaccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public BankDetail(String accountName, String iFSC, String accountNum) {
		this.accountName = accountName;
		IFSC = iFSC;
		this.accountNum = accountNum;
	}
	public BankDetail() {
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String getRegisteredMobileNumber() {
		return registeredMobileNumber;
	}
	public void setRegisteredMobileNumber(String registeredMobileNumber) {
		this.registeredMobileNumber = registeredMobileNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getPaymemtMethodName() {
		return paymemtMethodName;
	}
	public void setPaymemtMethodName(String paymemtMethodName) {
		this.paymemtMethodName = paymemtMethodName;
	}
	
}
