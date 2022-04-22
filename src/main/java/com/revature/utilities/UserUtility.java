package com.revature.utilities;

import java.util.Scanner;

import com.revature.dao.UserDAO;

public class UserUtility {

	private static boolean usernameExists = false;

	private static UserDAO userDAO = new UserDAO();

	private static Scanner sc = new Scanner(System.in);
	public static void register() {
		
	}
	
	public static void logIn() {
		pause();
		display("Username:");
		String username = sc .next();
		while(!usernameExists(username)) {
			
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
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
