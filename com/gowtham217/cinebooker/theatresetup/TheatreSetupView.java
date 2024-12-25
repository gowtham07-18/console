package com.gowtham217.cinebooker.theatresetup;

import java.util.Scanner;

import com.gowtham217.cinebooker.cinebookerrepository.CineBookerRepository;
import com.gowtham217.cinebooker.database.Database;
import com.gowtham217.cinebooker.dto.Theatre;

public class TheatreSetupView {

	private TheatreSetupModel setupModel;
	private Scanner sc = new Scanner(System.in);

	public TheatreSetupView() {
		this.setupModel = new TheatreSetupModel(this);
	}
	
	public void alreadyTheatreSet() {
		System.out.println("Enter you TheatreId:");
		int theatreId = sc.nextInt();
		setupModel.startSetup(theatreId);
	}
	
	public void forgotTheatreId() {
		System.out.println("Enter you email");
		String email = sc.nextLine();
		int id = Database.getInstance().getTheatreId(email);
		System.out.println("The theatre id of your theatre is "+id);
		alreadyTheatreSet();
	}
	
	public void init() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("1. New Theatre Setup");
		System.out.println("2. If already set");
		System.out.println("-----------------------------------------------------------------------");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			initiateSetup();
		case 2:
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1. Enter theatreId to set theatre");
			System.out.println("2. Forgot Theatre Id");
			System.out.println("-------------------------------------------------------------------");

			int option = sc.nextInt();
			switch(option) {
			case 1:
				alreadyTheatreSet();
				break;
			case 2:
				forgotTheatreId();
				break;
			default:
				System.out.println("Invalid choice give correct choice from given one");	
			}
		default:
			System.out.println("Invalid choice give correct choice from given one");
		}
	}

	public void initiateSetup() {
		
		System.out.println("---------------------------Theatre Setup---------------------------------");
		System.out.println("\n\nEnter Theatre details:");
		Theatre theatre = new Theatre();
		System.out.println("\nEnter Theatre name:");
		theatre.setTheatreName(sc.nextLine());
		System.out.println("\nEnter Theatre location:");
		theatre.setLocation(sc.nextLine());
		System.out.println("\nEnter no of screens in theatre:");
		theatre.setNoOfScreens(sc.nextInt());
		System.out.println("-------------------------------------------------------------------");
		setupModel.createTheatre(theatre);

	}
	
	

}
