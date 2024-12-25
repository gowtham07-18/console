package com.gowtham217.liftPass.liftsetup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gowtham217.liftPass.dto.Lift;
import com.gowtham217.liftPass.liftImpl.LiftView;

public class LiftSetupView {
	
	private LiftSetupModel setupModel;
	
	public LiftSetupView() {
		setupModel = new LiftSetupModel(this);
	}

	public void init() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcom the Lift Management System");
		System.out.println("\nEnter the No. of Lifts to set");
		int noOfLifts = scanner.nextInt();
		System.out.println("\nEnter the No. of Floors to set");
		int noOfFloors = scanner.nextInt();
		System.out.println();
		
		setupModel.startSetup(noOfLifts, noOfFloors);
		scanner.close();
	}
	
	public List<Integer> accessibleFloors(int id){
		
		Scanner scanner = new Scanner(System.in);
		List<Integer> stops = new ArrayList<>();
		System.out.println("Enter the total no. of Accessible floors for the L"+(int)(id+1));
		int noOfaccessibleFloors = scanner.nextInt();
		System.out.println("Enter the floors that are accessible");
		for(int j=0;j<noOfaccessibleFloors; j++) {
			stops.add(scanner.nextInt());
		}
		return stops;
	}

	public void display(Lift[] lifts) {
		
		System.out.println("Lift set Successfully!");
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
        System.out.println("\n---------------------------------------------------------------------");
        
        new LiftView().init();
	}
	

}
