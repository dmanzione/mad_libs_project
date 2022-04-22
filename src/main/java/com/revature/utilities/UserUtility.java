package com.revature.utilities;

import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.models.UserModel;

public class UserUtility {

	private static boolean usernameExists = false;

	private static UserDAO userDAO = new UserDAO();

	private static Scanner sc = new Scanner(System.in);
	
	private static boolean receivedGoodInput = false;

	public static void register() {
		pause();

		UserModel newUser = new UserModel();
		display("Please choose a username:");
		String username = sc.nextLine();
		while (userDAO.usernameExists(username)) {
			display("Username is already taken.\n");
			display("\nPlease choose a username:");
			username = sc.nextLine();
			pause();
		}
		newUser.username = username;
		display("Please choose a password:");
		newUser.password = sc.nextLine();

		userDAO.addUser(newUser);
		pause();

		display("Thank you for creating an account with us.\n");
		pause();
		display("\nPlease log in with your new credentials");
		logIn();

	}

	public static void logIn() {
		pause();
		display("Username:");
		String username = sc.nextLine();
		while (!usernameExists(username)) {
			display("That username is not registered." + "\n\nUsername: ");
			username = sc.next();

		}

		pause();

		display("Password:");
		String password = sc.nextLine();
		UserModel user = userDAO.getUser(username);
		
		while (!user.password.equals(password)) {
			display("Incorrect password.\n");
			display("Please try again.");
			display("Password:");
			password = sc.nextLine();

		}
		
		goToHomepage(user);

	}

	private static void goToHomepage(UserModel user) {
		pause();
		display("Welcome to your home page, "+user.username);
		pause();
		selectMadlibAction();
		
	}

	private static void selectMadlibAction() {
	
		
		while(!receivedGoodInput) {
			display("Please choose from the below options:\n");
			pause();
			display("A. Create New Mad Lib");
			pause();
			display("B. View Mad Libs");
			String input = sc.next();
			if(input.equals("A")||input.equals("a")) {
				receivedGoodInput = true;
				MadLibUtility.createNewMadLib();
			}else if(input.equals("B")||input.equals("b")) {
				receivedGoodInput = true;
				MadLibUtility.viewMadLibs();
			}else {
				pause();
				display("Invalid input.\n");
				
			}
		}
		
		
	}

	private static boolean usernameExists(String username) {

		return userDAO.usernameExists(username);
	}

	private static void display(String message) {
		System.out.println(message);

	}

	private static void pause() {
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
