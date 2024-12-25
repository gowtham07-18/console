package com.gowtham217.liftPass.liftImpl;

import com.gowtham217.liftPass.dto.Lift;
import com.gowtham217.liftPass.repository.LiftPassRepository;

class LiftModel {

	private LiftView view;
	
	LiftModel(LiftView view){
		this.view = view;
	}

	public void assignLift(int sourceFloor, int destinationFloor) {
		
	    Lift[] lifts = LiftPassRepository.getInstance().getLifts();
	    if (isAllareGroundFloor(lifts)) {
	        lifts[0].setCurrentPlace(destinationFloor);
	        view.liftShow(lifts, lifts[0].getId(), destinationFloor);
	        return; 
	    }
	    int distance = Math.abs(sourceFloor - lifts[0].getCurrentPlace());
	    Lift nearestLift = lifts[0];
	    
	    for (Lift lift : lifts) {
	        int currentDistance = Math.abs(sourceFloor - lift.getCurrentPlace());
	        if (currentDistance < distance) {
	            distance = currentDistance;
	            nearestLift = lift;
	        }
	        else if (currentDistance == distance) {
	            if (sourceFloor > destinationFloor && lift.getCurrentPlace() > sourceFloor) {
	                nearestLift = lift;
	            }
	        }
	    }
	    nearestLift.setCurrentPlace(destinationFloor);
	    view.liftShow(lifts, nearestLift.getId(), destinationFloor);
	}


	public boolean isAllareGroundFloor(Lift[] lifts) {
		for(Lift lift: lifts) {
			if(lift.getCurrentPlace() != 0) return false;
		}
		return true;
	}
	
	public boolean validateFloorInput(int floor) {
		if(floor<0 || floor>=LiftPassRepository.getInstance().getNoOfFloors()) {
			System.out.println("Invalid floor. Please enter a value between 0 and "+LiftPassRepository.getInstance().getNoOfFloors());
			return false;
		}
		return  true;
	}
	
	


}
