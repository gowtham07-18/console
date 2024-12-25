package com.gowtham217.cinebooker.cinebookerrepository;

import com.gowtham217.cinebooker.database.Database;
import com.gowtham217.cinebooker.dto.Theatre;

public class CineBookerRepository {

	private static CineBookerRepository repository;
	private Theatre theatre;
	
	private CineBookerRepository() {}
	
	public static CineBookerRepository getInstance() {
		if(repository == null) {
			repository = new CineBookerRepository();
		}
		return repository;
	}
	
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	
	
}
