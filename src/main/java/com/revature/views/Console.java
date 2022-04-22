package com.revature.views;

import java.util.Scanner;

import com.revature.utilities.UserUtility;

public class Console {
	static boolean receivedGoodInput = false;
	static Scanner sc = new Scanner(System.in);

	public static void run() {

		pause();

		display("Welcome to MadLibs!\n");

		pause();

		selectAction();

		pause();

	}

	private static void selectAction() {
		display("Please choose an option: " + "\nA. Log in" + "\nB. Register");

		while (!receivedGoodInput) {
			String input = sc.nextLine();
			if (input.equals("A") || input.equals("a")) {
				UserUtility.logIn();
				receivedGoodInput = true;

			} else if (input.equals("B") || input.equals("b")) {

				UserUtility.register();
				receivedGoodInput = true;

			} else {
				display("Invalid Input");
			}

		}
	}

	
	private static void pause() {
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void display(String message) {
		System.out.println(message);

	}

}
