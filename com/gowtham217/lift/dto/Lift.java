package com.gowtham217.lift.dto;

public class Lift {
	
	private String liftName;
	private int currentPlace;
	private double loadingCapacity;
	
	
	public Lift(String liftName, int currentPlace, double loadingCapacity) {
		this.liftName = liftName;
		this.currentPlace = currentPlace;
		this.loadingCapacity = loadingCapacity;
	}


	public String getLiftName() {
		return liftName;
	}
	public void setLiftName(String liftName) {
		this.liftName = liftName;
	}
	public int getCurrentPlace() {
		return currentPlace;
	}
	public void setCurrentPlace(int currentPlace) {
		this.currentPlace = currentPlace;
	}
	public double getLoadingCapacity() {
		return loadingCapacity;
	}
	public void setLoadingCapacity(double loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}
	
	
}
