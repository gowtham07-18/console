package com.gowtham217.liftPass.repository;

import com.gowtham217.liftPass.dto.Lift;

public class LiftPassRepository {
	
	private static LiftPassRepository repository;
	
	private int noOfLifts;
	private int noOfFloors;
	private Lift[] lifts;
	
	private LiftPassRepository() {}
	
	public static LiftPassRepository getInstance() {
		if(repository == null) {
			repository = new LiftPassRepository();
		}
		return repository;
	}

	public int getNoOfLifts() {
		return noOfLifts;
	}

	public void setNoOfLifts(int noOfLifts) {
		this.noOfLifts = noOfLifts;
	}

	public int getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public Lift[] getLifts() {
		return lifts;
	}

	public void setLifts(Lift[] lifts) {
		this.lifts = lifts;
	}


	
	
	
	
	
}
