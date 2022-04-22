package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.MadLibModel;

public interface MadLibDAOInterface {
	//by Patrick Buford
	
	
	//gets all mad libs
	public ArrayList<MadLibModel> getAll();
	//user reads completed story
	public MadLibModel tellMadLib(String name);
	
	//user fills out new MadLib
	public void saveMadLib(MadLibModel madLib);
	// or
	//public static void playMadLib(String newName);
	
	boolean madLibExists(String name);

}
