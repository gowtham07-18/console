package com.gowtham217.cinebooker.signup;

import java.util.Scanner;

import com.gowtham217.cinebooker.dto.User;
import com.gowtham217.cinebooker.theatresetup.TheatreSetupView;

public class SignupView {

	private SignupModel signupModel;
	
	public SignupView() {
		this.signupModel = new SignupModel(this);
	}
	
	public void init() {
		System.out.println("--------------------------------Signup Page----------------------------------");
		System.out.println("1. User Signup");
		System.out.println("2. Admin Signup");
		System.out.println("-----------------------------------------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		System.out.println("Please enter the below details");
        System.out.println("Enter your username:");
        String userName = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = sc.nextLine();
        
        switch (choice) {
        case 1:
            System.out.println("Signing up as User...");
            User user = new User(userName,password,email,phoneNumber);
            signupModel.userSignup(user,false);
            break;

        case 2:
            System.out.println("Signing up as Admin...");
            User admin = new User(userName,password,email,phoneNumber);
            signupModel.userSignup(admin,true);
            break;

        default:
            System.out.println("Invalid choice. Please try again.");
        }
        
        sc.close();
	}
	
	public void onSuccessSignup(User user, boolean isAdmin) {
		System.out.println("Signup Successfull! Welcome "+user.getUserName());
		if(isAdmin) {
			new TheatreSetupView().init();
		}
		else {
			
		}
	}
	
	public void onFailureSignup() {
		init();
	}
	
	
	
	
}
