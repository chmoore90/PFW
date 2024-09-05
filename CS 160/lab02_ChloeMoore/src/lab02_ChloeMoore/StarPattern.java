/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Lab 02
 * Prints a star pattern and calculates how many stars a pattern will have, depending on the number of columns.
 */

package lab02_ChloeMoore;

import javax.swing.JOptionPane; //Need for JOptionPane class.

public class StarPattern {

	public static void main(String[] args) {
		// Step 3
		String pattern;
		
		int pane = JOptionPane.showConfirmDialog(null, "Do you want to enter number?", "title", JOptionPane.YES_NO_CANCEL_OPTION);
		if (pane == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "you cancelled", "title", JOptionPane.YES_NO_CANCEL_OPTION);
		}

		// Step 4
		pattern = new String("\n     *" + "\n    * *" + "\n   * * *" + "\n  * * * *" + "\n * * * * *" + "\n* * * * * *"
				+ "\n * * * * *" + "\n  * * * *" + "\n   * * *" + "\n    * *" + "\n     *");

		// Step 5a
		String str = "Number of characters in the pattern: " + pattern.length();

		// Step 5b
		System.out.println(pattern);

		JOptionPane.showMessageDialog(null, str);
		JOptionPane.showMessageDialog(null, "The pattern is: " + pattern);

		// Step 7
		int asterisks;

		// Step 8
		int numberOfColumns = 6;

		asterisks = calcAsterisks(numberOfColumns); // call method

		// Step 9
		String output1 = "The number of * symbols in the lines of the pattern are: ";
		String output2 = "1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1";
		String output3 = "The total number of * symbols in the pattern is: %d";

		System.out.println(output1);
		System.out.println(output2);
		System.out.printf(output3, asterisks);

		JOptionPane.showMessageDialog(null, output1);
		JOptionPane.showMessageDialog(null, output2);
		JOptionPane.showMessageDialog(null, (String.format(output3, asterisks)));

		// Step 11
		numberOfColumns = (int) Double
				.parseDouble(JOptionPane.showInputDialog("How many columns should the star pattern have?"));
		asterisks = calcAsterisks(numberOfColumns);
		JOptionPane.showMessageDialog(null,
				String.format("A star pattern with %d columns has %d stars.", numberOfColumns, asterisks));

		System.exit(0); // closing JOption.Pane class
	}// end of main
/**
 * Calculates number of stars in a pattern, given a number of columns
 * @param number int type, number of columns
 * @return int type, number of stars
 */
	public static int calcAsterisks(int number) {
		return (int) Math.pow(number, 2);
	}

}
