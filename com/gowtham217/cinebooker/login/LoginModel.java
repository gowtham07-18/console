package com.gowtham217.cinebooker.login;

import com.gowtham217.cinebooker.database.Database;

class LoginModel {

	private LoginView loginView;
	
	public LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void authendicateUser(String userName, String password, boolean isAdmin) {
		if(Database.getInstance().authenticateUser(userName, password, isAdmin)) {
			loginView.onSuccessLogin(userName,isAdmin);
		}
		else {
			System.out.println("Invalid username or Password");
			loginView.onFailureLogin();
		}
	}

}
