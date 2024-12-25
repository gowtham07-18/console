package com.gowtham217.moviepass;

import com.gowtham217.moviepass.login.LoginView;
import com.gowtham217.moviepass.scanner.Read;
import com.gowtham217.moviepass.signup.SignupView;

public class MoviePass {
	
	private static MoviePass moviePass;
	
	private MoviePass() {}
	
	public static MoviePass getInstance() {
		if(moviePass == null) {
			moviePass = new MoviePass();
		}
		return moviePass;
	}
	
	public String getAppName() {
		return MoviePass.class.getName();
	}
	
	public String getVersion() {
		return "0.0.1";
	}
	
	public void init() {

		System.out.println("Enter you choice:");
		int choice = Read.getScanner().nextInt();
		
		if(choice == 1) {
			new LoginView().init();
		}
		else if(choice == 2) {
			new SignupView().init();
		}
		else {
			System.out.println("Enter the valid choice from give one:");
			init();
		}

	}
	
	public static void main(String[] args) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("Welcome to the "+MoviePass.getInstance().getAppName()+" version: "+MoviePass.getInstance().getVersion());
		System.out.println("1. To Login");
		System.out.println("2. To Signup");
		System.out.println("------------------------------------------------------------------------------------------------------");
		MoviePass.getInstance().init();
		

	}


}
