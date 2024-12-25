package com.gowtham217.moviepass.scanner;

import java.util.Scanner;

public class Read {
	
	private static Scanner scanner;
	
	private Read() {}
	
	public static Scanner getScanner() {
		if(scanner==null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}

}
