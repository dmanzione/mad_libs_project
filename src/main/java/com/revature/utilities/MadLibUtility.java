package com.revature.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.MadLibDAO;
import com.revature.models.MadLibModel;

public class MadLibUtility {

	static Scanner sc = new Scanner(System.in);
	static MadLibDAO madLibDAO = new MadLibDAO();

	public static void createNewMadLib() {
		MadLibModel madLib = new MadLibModel();
		display("What would you like your Mad Lib to be named?\n");
		String name = sc.nextLine();
		while(madLibDAO.madLibExists(name)) {
			display("There is already a mad lib with that name.\n");
			display("Please choose another one:");
			name = sc.nextLine();
		}
		madLib.name = name;
		pause();
		display("Please enter a singular noun for the first underline:\n");
		madLib.noun = sc.nextLine();
		pause();
		display("Please enter the verb for the second underline:\n");
		madLib.verb = sc.nextLine();
		pause();
		display("Please enter the adjective for the third underline:\n");
		madLib.adjective = sc.nextLine();
		pause();
		display("Please enter the adverb for the fourth underline:");
		madLib.adverb = sc.nextLine();

		madLibDAO.saveMadLib(madLib);

		display("Check out your mad lib!\n\n");
		display(madLib.toString());
	}

	private static void pause() {
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void viewMadLibs() {

		ArrayList<MadLibModel> madLibs = new ArrayList<>();

		madLibs = madLibDAO.getAll();
		display("\t\t***** MAD LIBS ******\n\n");

		for (MadLibModel madLib : madLibs) {

			display("\n\t" + madLib.toString());
		}
	}

	private static void display(String message) {
		System.out.println(message);

	}

	public static void tellMadLib() {
		pause();
		display("\nWhat is the name of the mad lib?");
		String name = sc.nextLine();
		MadLibModel madLib = madLibDAO.tellMadLib(name);
		display(madLib.toString());
	}

}
