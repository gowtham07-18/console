

package com.gowtham217.cinebooker.theatresetup;

import com.gowtham217.cinebooker.cinebookerrepository.CineBookerRepository;
import com.gowtham217.cinebooker.database.Database;
import com.gowtham217.cinebooker.dto.Theatre;

public class TheatreSetupModel {
	
	private TheatreSetupView setupView;
	
	public TheatreSetupModel(TheatreSetupView setupView) {
		this.setupView = setupView;
	}
	
	public void createTheatre(Theatre theatre) {
		Database.getInstance().addTheatre(theatre);
		CineBookerRepository.getInstance().setTheatre(theatre);
		setupView.onSetupComplete(theatre);
	}

	public void startSetup(int theatreId) {
		
		Theatre theatre = Database.getInstance().getTheatre(theatreId);
		CineBookerRepository.getInstance().setTheatre(theatre);
		setupView.onSetupComplete(theatre);

		
		
		
	}

}
