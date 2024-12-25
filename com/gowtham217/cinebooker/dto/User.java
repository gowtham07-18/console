package com.gowtham217.cinebooker.dto;

public class User {
	
	private String userName;
	private String password;
	private String email;
	private String phoneNo;
	
	public User(String userName, String password, String email, String phoneNo) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
