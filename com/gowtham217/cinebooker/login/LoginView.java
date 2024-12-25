package com.gowtham217.cinebooker.login;

import java.util.Scanner;

import com.gowtham217.cinebooker.theatresetup.TheatreSetupView;

public class LoginView {

	private LoginModel loginModel;
	
	public LoginView() {
		this.loginModel = new LoginModel(this);
	}
	
	public void init() {
		System.out.println("--------------------------------Sign in Page----------------------------------");
		System.out.println("1. User Sign in");
		System.out.println("2. Admin Sign in");
		System.out.println("------------------------------------------------------------------------------");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		System.out.println("Please enter the below details");
		System.out.println("Enter user name"); 
		String userName = sc.next();
		System.out.println("Enter Password"); 
		String password = sc.next();
		System.out.println("please wait");
		
		switch(choice) {
		case 1:
            System.out.println("Signing in as User...");
			loginModel.authendicateUser(userName,password,false);
			break;
		case 2:
            System.out.println("Signing in as Admin...");
			loginModel.authendicateUser(userName,password,true);
			break;
			
		default: 
            System.out.println("Invalid choice. Please try again.");
		}
		sc.close();
	}

	public void onSuccessLogin(String userName, boolean isAdmin) {
		System.out.println("Login Successfull! Welcome "+userName);
		if(isAdmin) {
			new TheatreSetupView().init();
		}
		else {
			
		}
	}
	
	public void onFailureLogin() {
		init();
	}
	
}
