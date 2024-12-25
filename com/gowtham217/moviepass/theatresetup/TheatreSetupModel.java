package com.gowtham217.moviepass.theatresetup;

import com.gowtham217.moviepass.dto.Theatre;
import com.gowtham217.moviepass.repository.MoviePassRepository;

class TheatreSetupModel {
	
	private TheatreSetupView setupView;
	
	public TheatreSetupModel(TheatreSetupView setupView) {
		this.setupView = setupView;
	}

	public void startSetup() {
		if(MoviePassRepository.getInstance().getTheatre() == null) {
			setupView.initiateSetup();
		}
		
	}

	public void createTheatre(Theatre theatre) {
		
		if(!(theatre.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\r\n"+ ""))) {
			setupView.showAlert("Enter correct email format");
			return;
		}
		if(theatre.getName().length() < 3 || theatre.getName().length()>50) {
			setupView.showAlert("Enter the valid name");
			return;
		}
		
		MoviePassRepository.getInstance().setTheatre(theatre);
		
		setupView.onSetupComplete(theatre);
	}

}
