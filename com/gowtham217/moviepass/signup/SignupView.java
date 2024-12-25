package com.gowtham217.moviepass.signup;

import com.gowtham217.moviepass.scanner.Read;

public class SignupView {
	
	private SignupModel signupModel;
	
	public SignupView() {
		signupModel = new SignupModel(this);
	}

	public void init() {
		System.out.println("------------------------------------------------Signup Page-------------------------------------------");
		System.out.println("1. Admin Signup");
		System.out.println("2. User Signup");
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		int choice = Read.getScanner().nextInt();
		
		System.out.println("Enter your Username:");
		String userName = Read.getScanner().nextLine();
		System.out.println("Enter your FullName:");
		String name = Read.getScanner().nextLine();
		System.out.println("Enter your Phone Number:");
		String phoneNo = Read.getScanner().nextLine();
		System.out.println("Enter your Password");
		String password = Read.getScanner().nextLine();
		System.out.println();
		System.out.println("Please wait....");
		
		if(choice == 1) {
			signupModel.validation(userName,name,phoneNo,password,true);
		}
		else if(choice == 2) {
			signupModel.validation(userName,name,phoneNo,password,false);
		}
		else {
			System.out.println("Please the enter the choice from the given one");
			init();
		}
	}
	
	public void alert(String message) {
		System.out.println(message);
		init();
	}

	public void onSuccessLogin() {
		
		System.out.println("Signup Successful!");
		
		
	}

}
