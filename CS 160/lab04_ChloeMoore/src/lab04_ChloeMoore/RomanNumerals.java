/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023 
 * Lab 4
 * */

package lab04_ChloeMoore;

import javax.swing.JOptionPane;

public class RomanNumerals {

	public static void main(String[] args) {
		// inital variables
		int keep_on_rolling;
		String title = "Conversion of Roman Numerals";
		String task = "Enter a Roman numeral between \"I\" and \"XX\"";

		do {
			// input request window
			String roman = JOptionPane.showInputDialog(null, task, title, JOptionPane.QUESTION_MESSAGE);

			// verify cancelation or blank input
			if (roman == null) {
				JOptionPane.showMessageDialog(null, "You selected \"Cancel\".", title, JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "End of program.", title, JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else if (roman.length() == 0) {
				JOptionPane.showMessageDialog(null, "You have not entered a Roman numeral. Please try again.", title,
						JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "End of program.", title, JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}

			// format the input
			roman = roman.toUpperCase();
			int decimal = 0;

			// begin the if/else madness!
			// Group I
			if (roman.charAt(0) == 'I') {
				if (roman.equals("I")) {
					decimal = 1;
					call_display(title, roman, decimal);
				} else if (roman.equals("II")) {
					decimal = 2;
					call_display(title, roman, decimal);
				} else if (roman.equals("III")) {
					decimal = 3;
					call_display(title, roman, decimal);
				} else if (roman.equals("IV")) {
					decimal = 4;
					call_display(title, roman, decimal);
				} else if (roman.equals("IX")) {
					decimal = 9;
					call_display(title, roman, decimal);
				} else {
					call_error(title, roman);
				}
				// Group V
			} else if (roman.charAt(0) == 'V') {
				if (roman.equals("V")) {
					decimal = 5;
					call_display(title, roman, decimal);
				} else if (roman.equals("VI")) {
					decimal = 6;
					call_display(title, roman, decimal);
				} else if (roman.equals("VII")) {
					decimal = 7;
					call_display(title, roman, decimal);
				} else if (roman.equals("VIII")) {
					decimal = 8;
					call_display(title, roman, decimal);
				} else {
					call_error(title, roman);
				}
				// Group X
			} else if (roman.charAt(0) == 'X') {
				if (roman.equals("X")) {
					decimal = 10;
					call_display(title, roman, decimal);
				} else if (roman.equals("XI")) {
					decimal = 11;
					call_display(title, roman, decimal);
				} else if (roman.equals("XII")) {
					decimal = 12;
					call_display(title, roman, decimal);
				} else if (roman.equals("XIII")) {
					decimal = 13;
					call_display(title, roman, decimal);
				} else if (roman.equals("XIV")) {
					decimal = 14;
					call_display(title, roman, decimal);
				} else if (roman.equals("XV")) {
					decimal = 15;
					call_display(title, roman, decimal);
				} else if (roman.equals("XVI")) {
					decimal = 16;
					call_display(title, roman, decimal);
				} else if (roman.equals("XVII")) {
					decimal = 17;
					call_display(title, roman, decimal);
				} else if (roman.equals("XVIII")) {
					decimal = 18;
					call_display(title, roman, decimal);
				} else if (roman.equals("XIX")) {
					decimal = 19;
					call_display(title, roman, decimal);
				} else if (roman.equals("XX")) {
					decimal = 20;
					call_display(title, roman, decimal);
				} else {
					call_error(title, roman);
				}
			} else {
				call_error(title, roman);
			} // end if/else shennanigans

			// continue?
			keep_on_rolling = JOptionPane.showConfirmDialog(null, "Would you like to enter more Roman numerals?", title,
					JOptionPane.YES_NO_OPTION);

		} while (keep_on_rolling == 0); // end while loop

		// closing window
		JOptionPane.showMessageDialog(null, "End of program.", title, JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);

	} // end main

	// methods
	public static void call_display(String title, String roman, int decimal) {
		JOptionPane.showMessageDialog(null,
				String.format("The decimal value for the Roman numeral \"%s\" is:\n...... %d ......", roman, decimal),
				title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void call_error(String title, String roman) {
		JOptionPane.showMessageDialog(null, String.format("Input \"%s\" is not a valid Roman numeral.", roman), title,
				JOptionPane.INFORMATION_MESSAGE);

	}
}
