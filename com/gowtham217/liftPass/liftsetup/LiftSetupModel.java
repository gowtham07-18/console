package com.gowtham217.liftPass.liftsetup;

import java.util.List;
import com.gowtham217.liftPass.dto.Lift;
import com.gowtham217.liftPass.repository.LiftPassRepository;

class LiftSetupModel {
	
	LiftSetupView setupView;
	public LiftSetupModel(LiftSetupView setupView) {
		this.setupView = setupView;
	}

	public void startSetup(int noOfLifts, int noOfFloors) {
		
		
		LiftPassRepository.getInstance().setNoOfLifts(noOfLifts);
		LiftPassRepository.getInstance().setNoOfFloors(noOfFloors);
		
		Lift[] lifts = new Lift[noOfLifts];
		
		
		for(int i=0; i<noOfLifts; i++) {
			List<Integer>stops = setupView.accessibleFloors(i);
			lifts[i] = new Lift(i+1,0,stops);
		}
		
		LiftPassRepository.getInstance().setLifts(lifts);
		setupView.display(lifts);
		
	}

}
