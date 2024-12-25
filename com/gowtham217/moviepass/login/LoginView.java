package com.gowtham217.moviepass.login;

import com.gowtham217.moviepass.scanner.Read;
import com.gowtham217.moviepass.theatresetup.TheatreSetupView;

public class LoginView {
	
	private LoginModel loginModel;
	
	public LoginView(){
		loginModel = new LoginModel(this);
	}

	public void init() {
		
		System.out.println("------------------------------------------------Login Page-------------------------------------------");
		System.out.println("1. Admin Login");
		System.out.println("2. User Login");
		System.out.println("------------------------------------------------------------------------------------------------------");

		int choice = Read.getScanner().nextInt();
		
		System.out.println("Enter your Username: ");
		String userName = Read.getScanner().nextLine();
		System.out.println("Enter your Password");
		String password = Read.getScanner().nextLine();
		System.out.println();
		System.out.println("Please wait....");
		
		if(choice == 1) {
			loginModel.startLogin(userName,password,true);
		}
		else if(choice == 2) {
			loginModel.startLogin(userName, password, false);
		}
		
		
	}

	public void onLoginFailed(String alert) {
		System.out.println(alert);
		init();
	}

	public void onSuccessLogin(boolean isAdmin) {
		System.out.println("Login Successfull!");
		
		if(isAdmin) {
			new TheatreSetupView().init();
		}
		
	}
	
	

}
