package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.ConnectionManager;
import com.revature.models.MadLibModel;

public class MadLibDAO implements MadLibDAOInterface {

	public String noun;
	public String adjective;
	public String verb;
	public String adverb;
	public String username;
	public String name;

	private Connection kinect = ConnectionManager.getConnection();

	// user enters their ID and gets a list of their savefiles
	public ArrayList<MadLibModel> getUser(String username) {
		ArrayList<MadLibModel> myMadLibs = new ArrayList<>();
		try {
			Statement statement = kinect.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Mad_Lib WHERE UserID = '" + username + "';");

			while (rs.next()) {
				MadLibModel madLib = new MadLibModel();
				madLib.name = rs.getString("name");
				madLib.noun = rs.getString("noun");
				madLib.verb = rs.getString("verb");
				madLib.adjective = rs.getString("adverb");
				madLib.adverb = rs.getString("adverb");
				myMadLibs.add(madLib);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myMadLibs;

	}

	// user enters the name of their savefile and prints out the completed Madlib
	public MadLibModel tellMadLib(String name) {
		try {
			Statement statement = kinect.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Mad_Lib WHERE name = '" + name + "';");
			MadLibModel madLib = new MadLibModel();
			while (rs.next()) {
				madLib.name = rs.getString("name");
				madLib.noun = rs.getString("noun");
				madLib.adjective = rs.getString("adjective");
				madLib.verb = rs.getString("verb");
				madLib.adverb = rs.getString("adverb");

			}
			return madLib;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// makes a new Madlib row with the user's input and the name of their savefile
	public void saveMadLib(MadLibModel madLib) {
		try {
			String query = "INSERT into Mad_Lib (name, adjective, verb, adverb, noun) values (?, ?, ?, ?, ?)";
			// creates a prepared statement to run the query through the connection
			PreparedStatement pstmt = kinect.prepareStatement(query);
			pstmt.setString(1, madLib.name);
			pstmt.setString(2, madLib.adjective);
			pstmt.setString(3, madLib.verb);
			pstmt.setString(4, madLib.adverb);
			pstmt.setString(5, madLib.noun);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MadLibModel> getAll() {
		ArrayList<MadLibModel> myMadLibs = new ArrayList<>();
		try {
			Statement statement = kinect.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Mad_Lib");

			while (rs.next()) {
				MadLibModel madLib = new MadLibModel();
				madLib.name = rs.getString("name");
				madLib.noun = rs.getString("noun");
				madLib.verb = rs.getString("verb");
				madLib.adjective = rs.getString("adverb");
				madLib.adverb = rs.getString("adverb");
				myMadLibs.add(madLib);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myMadLibs;
	}
	
	@Override
	public boolean madLibExists(String name) {
		try {
			Statement statement = kinect.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Mad_Lib WHERE name = '" + name +"';");

			if (rs.next()) {
				return true;

			}else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
