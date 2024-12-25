package com.gowtham217.moviepass.signup;

import com.gowtham217.moviepass.dto.Credentials;
import com.gowtham217.moviepass.repository.MoviePassRepository;

class SignupModel {
	
	private SignupView signupView;
	
	SignupModel(SignupView signupView){
		this.signupView = signupView;
	}
	
	public void validation(String userName, String name, String phoneNo, String password, boolean isAdmin) {
		
		if(!(userName == null || userName.matches("^[a-z][a-z0-9]{2,19}$)"))){
			signupView.alert("UserName consits only lower case letters with numbers.");
		}
		if(!(name == null || name.matches("^[A-Za-z]+(?: [A-Za-z]+)*$\r\n"+ ""))) {
			signupView.alert("Name should not contain numbers");
		}
		if(!(phoneNo == null || phoneNo.matches("^\\d{10}$\r\n"+ ""))) {
			signupView.alert("Phone number should contain only 10 number");
		}
		if(!(password == null || password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n"+ ""))) {
			signupView.alert("Password should contain atleast 8 characters with numbers and special characters");
		}
		
		if(MoviePassRepository.getInstance().isUserNameExists(userName,isAdmin)) {
			signupView.alert("Username already exits");
		}
		
		Credentials credential = new Credentials(userName,password,phoneNo,name);
		MoviePassRepository.getInstance().addUser(credential,isAdmin);
		
		signupView.onSuccessLogin();
		
		
	}

}


