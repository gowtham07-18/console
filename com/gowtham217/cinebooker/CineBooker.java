package com.gowtham217.cinebooker;

import java.util.Scanner;

import com.gowtham217.cinebooker.login.LoginView;
import com.gowtham217.cinebooker.signup.SignupView;

public class CineBooker {
	
	private static CineBooker cineBooker;
	
	private CineBooker() {
		
	}
	
	public static CineBooker getInstance() {
		if(cineBooker == null) {
			cineBooker = new CineBooker();
		}
		return cineBooker;
	}
	
	public String getAppName() {
		return CineBooker.class.getName();
	}
	
	public String getVersion() {
		return "0.0.1";
	}

	public static void main(String[] args) {
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Welcome to the "+CineBooker.getInstance().getAppName()+ "Version: "+CineBooker.getInstance().getVersion());
		System.out.println("1. Login");
		System.out.println("2. Sign up");
		System.out.println("---------------------------------------------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			new LoginView().init();
			break;
		case 2:
			new SignupView().init();
			break;
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
		}
		
		sc.close();
	}

}
