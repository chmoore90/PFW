/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 3: At the ATM Machine
 *
 * Description: Main class of the application.
 *
 */

package project03_ChloeMoore;

import javax.swing.JOptionPane;

public class Applications {

	public static void main(String[] args) {
		// variables
		Account acc = null;
		ATM atm = null;
		boolean client = true;
		boolean transactionRequired;
		String title = "Application Window";

		// outer client loop
		while (client == true) {
			transactionRequired = true;
			int open_account = JOptionPane.showConfirmDialog(null,
					"Would you like to create an account?\nThe minimum deposit is $100.\n\nIf you already have an account, please select Cancel.",
					title, JOptionPane.YES_NO_CANCEL_OPTION);

			if (open_account == JOptionPane.YES_OPTION) {
				// yes selected
				double init_bal = Double.parseDouble((String) JOptionPane.showInputDialog(null,
						"Please enter an initial account balance.\nThe minimum is $100.\n\nIn the next window, you will be assigned a PIN number.",
						title, JOptionPane.QUESTION_MESSAGE, null, null, "100"));
				
				// loop to check that initial balance is at least 100
				while (init_bal < 100) {
					init_bal = Double.parseDouble((String) JOptionPane.showInputDialog(null,
							"Invalid initial deposit.\nThe minimum is $100.\n\nIn the next window, you will be assigned\na PIN number.",
							title, JOptionPane.QUESTION_MESSAGE, null, null, "100"));
				}
				// initiating acc and atm classes
				acc = new Account(init_bal);
				atm = new ATM(acc);
				
			} else if (open_account == JOptionPane.NO_OPTION) {
				// no selected
				System.out.println("Application has been terminated.");
				System.exit(0);
				
			} else if (acc == null) {
				// no account
				System.out.println("Sorry, your account does not exist.\nApplication has been terminated.");
				client = false;
				break;
			} else {
				atm = new ATM(acc);
			}

			// inner transaction loop
			while (transactionRequired == true) {
				int transact = JOptionPane.showConfirmDialog(null,
						"Would you like to make a transaction?\nSelecting No will cancel the current process.", title,
						JOptionPane.YES_NO_OPTION);
				if (transact == JOptionPane.NO_OPTION) {
					transactionRequired = false;
				} else {
					atm.transaction();
				}
				
			} // end of inner loop
		} // end outer loop
	} // end main
} // end of applications
