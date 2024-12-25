package com.gowtham217.cinebooker.signup;

import com.gowtham217.cinebooker.database.Database;
import com.gowtham217.cinebooker.dto.User;

public class SignupModel {

	private SignupView signupView;
	
	public SignupModel(SignupView signupView) {
		this.signupView = signupView;
	}

	public void userSignup(User user, boolean isAdmin) {
		if(Database.getInstance().registerUser(user,isAdmin)){
			signupView.onSuccessSignup(user,isAdmin);
		}
		else {
            System.out.println("User signup failed. Username might already exist.");
            signupView.onFailureSignup();
		}
	}
	
	
}
