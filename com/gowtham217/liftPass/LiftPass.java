package com.gowtham217.liftPass;

import com.gowtham217.liftPass.liftsetup.LiftSetupView;

public class LiftPass {
	
	private static LiftPass liftPass;
	
	private LiftPass() {}
	
	public static LiftPass getInstance() {
		if(liftPass == null) {
			liftPass = new LiftPass();
		}
		return liftPass;
	}
	
	public void init() {
		new LiftSetupView().init();
	}
	
	public static void main(String[] args) {
		LiftPass.getInstance().init();
	}

}
