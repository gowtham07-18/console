package com.gowtham217.moviepass.login;

import com.gowtham217.moviepass.dto.User;
import com.gowtham217.moviepass.repository.MoviePassRepository;

class LoginModel {
	private LoginView loginView;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void startLogin(String userName, String password, boolean isAdmin) {
		
		if(isAdmin) {
			User adminUser = MoviePassRepository.getInstance().checkValidUser(userName,password,true);	
			if(adminUser == null) {
				loginView.onLoginFailed("Invalid User/Password");
			}
			else {
				loginView.onSuccessLogin(isAdmin);
			}
		}
		else {
			User userUser = MoviePassRepository.getInstance().checkValidUser(userName, password,false);
		}
	}
}
