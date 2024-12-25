package com.gowtham217.liftPass.liftImpl;

import java.util.Scanner;

import com.gowtham217.liftPass.dto.Lift;
import com.gowtham217.liftPass.repository.LiftPassRepository;

public class LiftView {

	private LiftModel model;
	
	public LiftView() {
		model = new LiftModel(this);
	}

	public void init() {
		
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("1. Request a Lift\n2. Exit");
		
		int choice = scanner.nextInt();
		
		if(choice==1) {
			startLift();
		}
		else if(choice==2) {
            System.out.println("Exiting Lift Management System...");
            System.exit(0);
		}
		else {
			System.out.println("Enter the correct choice from the given one");
		}
		scanner.close();
	}
	
	public void startLift() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEnter the source floor:");
		int sourceFloor = scanner.nextInt();
		if(!model.validateFloorInput(sourceFloor)) {
			startLift();
		}
		System.out.println("\nEnter the destination floor:");
		int destinationFloor = scanner.nextInt();
		if(!model.validateFloorInput(sourceFloor)) {
			startLift();
		}
		model.assignLift(sourceFloor,destinationFloor);
		
		scanner.close();
	}

	public void liftShow(Lift[] lifts, int id, int destinationFloor) {
		
		System.out.println("---------------------------------------");
		System.out.println("L"+id +" is assigned");
		System.out.println("L"+id + "is arrived on "+destinationFloor+" floor");
		System.out.println();
        System.out.print("Lift   : ");
        for (Lift lift : lifts) {
            System.out.print("L" + lift.getId() + " ");
        }
        System.out.println();

        System.out.print("Floor  : ");
        for (Lift lift : lifts) {
            System.out.print(lift.getCurrentPlace() + "  ");
        }
		System.out.println("\n---------------------------------------");
		
		LiftPassRepository.getInstance().setLifts(lifts);
		init();
		
	}
	


}
