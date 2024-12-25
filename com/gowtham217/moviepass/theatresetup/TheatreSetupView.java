package com.gowtham217.moviepass.theatresetup;

import com.gowtham217.moviepass.dto.Theatre;
import com.gowtham217.moviepass.scanner.Read;

public class TheatreSetupView {
	
	private TheatreSetupModel setupModel;
	
	public TheatreSetupView() {
		setupModel = new TheatreSetupModel(this);
	}

	public void init() {
		setupModel.startSetup();
		
	}

	public void initiateSetup() {
		System.out.println("\n\nEnter Theatre details");
		Theatre theatre = new Theatre();
		System.out.println("\nEnter Theatre name:");
		theatre.setName(Read.getScanner().nextLine());
		System.out.println("\nEnter Theatre Location");
		theatre.setLocation(Read.getScanner().nextLine());
		System.out.println("\nEnter Theatre Email");
		theatre.setEmail(Read.getScanner().nextLine());
		System.out.println("\nEnter Id to set for theatre:");
		theatre.setId(Read.getScanner().nextLong());
		System.out.println("Processing, Please wait....");
		
		setupModel.createTheatre(theatre);
		
		
	}


	public void showAlert(String message) {
		System.out.println(message);
		initiateSetup();
		
	}

	public void onSetupComplete(Theatre theatre) {
		System.out.println("\nTheatre setup Completed");
		System.out.println("\nCurrent Theatre Name - " + theatre.getName());
		
	}

}
