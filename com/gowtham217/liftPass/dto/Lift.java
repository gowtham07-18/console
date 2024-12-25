package com.gowtham217.liftPass.dto;

import java.util.List;

public class Lift {
	
	private int id;
	private int currentPlace;
	
	private List<Integer> stops;
	
	
	public Lift(int id,int currentPlace, List<Integer> stops) {
		this.id = id;
		this.currentPlace = currentPlace;
		this.setStops(stops);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCurrentPlace() {
		return currentPlace;
	}
	public void setCurrentPlace(int currentPlace) {
		this.currentPlace = currentPlace;
	}

	public List<Integer> getStops() {
		return stops;
	}

	public void setStops(List<Integer> stops) {
		this.stops = stops;
	}

}
