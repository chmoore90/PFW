/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023 
 * Lab 5
 *
 */

package lab05_ChloeMoore;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Order3Strings {

	public static void main(String[] args) {
		//// initial variables
		String title = "Three Strings";
		int response = 0;

		//// initiate program
		response = JOptionPane.showConfirmDialog(null, "Do you want to compare strings?", title,
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "You chose not to begin.\nProgram terminates now.\nEnd of program.",
					title, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("You chose not to begin. Program terminates now. End of program.");
			System.exit(0);
		}

		//// main program loop
		do {
			//// validate input
			String names = JOptionPane.showInputDialog(null, "Enter 3 names, using spaces as separators.", title,
					JOptionPane.QUESTION_MESSAGE);
			if (names == null) {
				JOptionPane.showMessageDialog(null, "You have selected Cancel.", title,
						JOptionPane.INFORMATION_MESSAGE);
				terminate(title);
			} else if (names.equals("")) {
				JOptionPane.showMessageDialog(null, "Input error: You have not entered any names.", title,
						JOptionPane.INFORMATION_MESSAGE);
				terminate(title);
			} else if (names.equals("null")) {
				JOptionPane.showMessageDialog(null, "You have entered \"null\" which is not a vaid name.", title,
						JOptionPane.INFORMATION_MESSAGE);
				terminate(title);
			}

			//// validate names
			Scanner splitter = new Scanner(names);
			String name1 = "";
			String name2 = "";
			String name3 = "";

			// checking for three names
			if (splitter.hasNext()) {
				name1 = splitter.next().strip();
			} else {
				is_invalid(title);
				terminate(title);
			}
			if (splitter.hasNext()) {
				name2 = splitter.next().strip();
			} else {
				is_invalid(title);
				terminate(title);
			}
			if (splitter.hasNext()) {
				name3 = splitter.next().strip();
			} else {
				is_invalid(title);
				terminate(title);
			}

			// checking for repeats or "null"
			if (name1.equals(name2) || name1.equals(name3) || name2.equals(name3)) {
				is_invalid(title);
				terminate(title);
			}
			if (name1.toLowerCase().equals("null") || name2.toLowerCase().equals("null")
					|| name3.toLowerCase().equals("null")) {
				is_invalid(title);
				terminate(title);
			}

			// capitalize names
			name1 = name1.substring(0, 1).toUpperCase() + name1.substring(1, name1.length());
			name2 = name2.substring(0, 1).toUpperCase() + name2.substring(1, name2.length());
			name3 = name3.substring(0, 1).toUpperCase() + name3.substring(1, name3.length());

			//// alphabetize!
			String names_ordered;
			if (name1.compareToIgnoreCase(name2) < 0 && name1.compareToIgnoreCase(name3) < 0) {
				if (name2.compareToIgnoreCase(name3) < 0) {
					names_ordered = String.format("%s, %s, %s", name1, name2, name3);
					display(title, names_ordered);
				} else {
					names_ordered = String.format("%s, %s, %s", name1, name3, name2);
					display(title, names_ordered);
				}
			} else if (name2.compareToIgnoreCase(name1) < 0 && name2.compareToIgnoreCase(name3) < 0) {
				if (name1.compareToIgnoreCase(name3) < 0) {
					names_ordered = String.format("%s, %s, %s", name2, name1, name3);
					display(title, names_ordered);
				} else {
					names_ordered = String.format("%s, %s, %s", name2, name3, name2);
					display(title, names_ordered);
				}
			} else if (name3.compareToIgnoreCase(name1) < 0 && name3.compareToIgnoreCase(name2) < 0) {
				if (name1.compareToIgnoreCase(name2) < 0) {
					names_ordered = String.format("%s, %s, %s", name3, name1, name2);
					display(title, names_ordered);
				} else {
					names_ordered = String.format("%s, %s, %s", name3, name2, name1);
					display(title, names_ordered);
				}
			}

			//// continue?
			response = JOptionPane.showConfirmDialog(null, "Do you want to continue and compare more strings?", title,
					JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"You chose not to continue.\nProgram terminates now.\nEnd of program.", title,
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println("You chose not to continue. Program terminates now. End of program.");
				System.exit(0);
			}

			splitter.close();
		} while (response == 0);

	} // end main

	public static void display(String title, String names) {
		JOptionPane.showMessageDialog(null,
				String.format("Here are your three names in lexographical order:\n%s", names), title,
				JOptionPane.INFORMATION_MESSAGE);
		System.out.println(String.format("Here are your three names in lexographical order:\n%s", names));
	}

	public static void is_invalid(String title) {
		JOptionPane.showMessageDialog(null, "Your input is invalid", title, JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Your input is invalid");
	}

	public static void terminate(String title) {
		JOptionPane.showMessageDialog(null, "Program terminates now.\nEnd of program.", title,
				JOptionPane.WARNING_MESSAGE);
		System.out.println("Program terminates now. End of program.");
		System.exit(0);
	} // end terminate
}
