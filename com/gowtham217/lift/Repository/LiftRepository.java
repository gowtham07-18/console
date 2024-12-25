package com.gowtham217.lift.Repository;

import com.gowtham217.lift.dto.Lift;

public class LiftRepository {
	
	private static LiftRepository repository;
	
	private Lift[] lifts = new Lift[5];
	
	private LiftRepository() {}
	
	public static LiftRepository getInstance() {
		if(repository == null) {
			repository = new LiftRepository();
		}
		return repository;
	}
	
	
	public void liftsSetup() {
		for(int i=0; i<5; i++) {
			int num = i+1;
			lifts[i] = new Lift("L"+num,0,500);
		}
	}
	
	public Lift[] getLifts() {
		return lifts;
	}

}
