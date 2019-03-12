package com.usermanagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "userasd")
public class User extends Common{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String mobileNumber;

	//@Column(unique = true, nullable = false)
	@Column(unique = true)
	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.UNDEFINED;

	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.NON_PRIME;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BankDetail> bankDetails = new ArrayList<BankDetail>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
	private UserBalance userBalance = new UserBalance();
	
	private Boolean isMobileVerified = false;
	
	private String OTP = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<BankDetail> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(List<BankDetail> bankDetails) {
		this.bankDetails = bankDetails;
		this.bankDetails.forEach(x -> x.setUser(this));
	}

	public Boolean getIsMobileVerified() {
		return isMobileVerified;
	}

	public void setIsMobileVerified(Boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public UserBalance getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(UserBalance userBalance) {
		this.userBalance = userBalance;
	}


}
