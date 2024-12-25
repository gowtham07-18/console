package com.gowtham217.moviepass.repository;

import java.util.ArrayList;

import java.util.List;

import com.gowtham217.moviepass.dto.Credentials;
import com.gowtham217.moviepass.dto.Theatre;
import com.gowtham217.moviepass.dto.User;

public class MoviePassRepository {
	
	private static MoviePassRepository repository;
	
	private MoviePassRepository() {}
	
	private List <Credentials> adminCredentials = new ArrayList<Credentials>();
	private List <Credentials> userCredentials = new ArrayList<Credentials>();
	private Theatre theatre;
	
	public static MoviePassRepository getInstance() {
		if(repository == null) {
			repository = new MoviePassRepository();
		}
		return repository;
	}

	public boolean isUserNameExists(String userName,boolean isAdmin) {
		
		if(isAdmin) {
			for(Credentials credential : adminCredentials) {
				if(credential.getUserName().equals(userName)) {
					return true;
				}
			}
		}
		else {
			for(Credentials credential : userCredentials) {
				if(credential.getUserName().equals(userName)) {
					return true;
				}
			}
		}
		return true;
	}
	
	public void addUser(Credentials credential,  boolean isAdmin) {
		if(isAdmin) {
			adminCredentials.add(credential);
		}
		else {
			userCredentials.add(credential);
		}
	}

	public User checkValidUser(String userName, String password, boolean isAdmin) {
		if(isAdmin) {
			for (Credentials credential : adminCredentials) {
				if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
					return credential; 
				}
			}
		}
		else if(!isAdmin) {
			for (Credentials credential : userCredentials) {
				if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
					return credential; 
				}
			}
		}
		return null;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
		
	}
	
	public Theatre getTheatre() {
		return theatre;
	}
	
}
