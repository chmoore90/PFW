/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 3: At the ATM Machine
 *
 * Description: ATM class that contains the methods for ATM transactions (eg. withdrawals and deposits)
 *
 */

package project03_ChloeMoore;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ATM {
	// ATM variables
	private Account acc;
	private Scanner keyboard = new Scanner(System.in);
	final private String title = "ATM Machine";

	// ATM constructor
	ATM(Account account) {
		acc = account;
	}

	// ATM methods
	void transaction() {
		String action = JOptionPane.showInputDialog(null,
				"What would you like to do?\n\nEnter \"w\" to make a withdrawal.\nEnter \"d\" to make a deposit.",
				title, JOptionPane.QUESTION_MESSAGE);
		System.out.println(action);

		if (action.toLowerCase().equals("w")) {
			// getting user PIN
			System.out.println("Please enter your PIN number: ");
			int user_pin = keyboard.nextInt();

			if (user_pin == acc.getPin()) {
				int w = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter the amount you would like to withdraw: ", title, JOptionPane.QUESTION_MESSAGE));
				acc.withdraw(w);
				acc.showBalance();
			} else {
				System.out.println("Incorrect PIN. This transaction has been aborted.");
			}

		} else if (action.toLowerCase().equals("d")) {
			JOptionPane.showMessageDialog(null,
					"We accept the following dollar bills:\n1, 5, 10, 20, 50, 100\n\nPlease insert your bills on the console."
							+ "\nWhen you are finished, enter any other number to continue.",
					title, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Enter your bills here: ");

			int sum = 0;
			int bill = keyboard.nextInt();
			while (bill == 1 || bill == 5 || bill == 10 || bill == 20 || bill == 50 || bill == 100) {
				sum += bill;
				bill = keyboard.nextInt();
			}
			acc.deposit(sum);
			acc.showBalance();

		}

	}
} // end class
