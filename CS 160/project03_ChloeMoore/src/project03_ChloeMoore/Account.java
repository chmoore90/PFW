/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 3: At the ATM Machine
 *
 * Description: Account class to update balance and assign pins
 *
 */

package project03_ChloeMoore;

import java.util.Random;
import javax.swing.JOptionPane;

public class Account {
	// account variables
	private double balance;
	private int pin;
	final private String title = "User Account";

	// initialize class

	// account constructor
	public Account(double bal) {
		setBalance(bal);
		createPin();
		JOptionPane.showMessageDialog(null, String.format(
				"Your assigned PIN is:\n%04d\n\nDo not forget this number.\nIt will not be displayed again.", pin), title, JOptionPane.INFORMATION_MESSAGE);
	}

	// account methods
	public int getPin() {
		return pin;
	}

	public void createPin() {
		Random rand = new Random();
		pin = rand.nextInt(10000);

		System.out.println("Pin created: " + pin); // TESTING TESTING TESTING
	}

	public void setBalance(double bal) {
		balance = Math.abs(bal);
	}

	public void showBalance() {
		JOptionPane.showMessageDialog(null, String.format("The current balance is\n$%.2f", balance), title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void deposit(int dep) {
		balance += Math.abs(dep);
	}

	public void withdraw(int wit) {
		if (balance > wit) {
			balance -= wit;
		} else {

			System.out.println(String.format("Your request exceeds your available funds.\n"
					+ "You will receive your total balance of $%.2f. Your balance is now $0.00", balance));
			balance = 0;
		}
	}

	public double getBalance() {
		return balance;
	}
} // end class
