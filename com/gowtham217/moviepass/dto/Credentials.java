package com.gowtham217.moviepass.dto;

public class Credentials extends User {
	
	private String password;
	
	public Credentials(String userName, String password, String phoneNo,String name) {
		super.setName(name);
		super.setUserName(userName);
		super.setPhoneNo(phoneNo);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
