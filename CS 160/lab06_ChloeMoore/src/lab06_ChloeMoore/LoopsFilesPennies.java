/*
 * Chloe Moore
 * CS 16000-01 02/03, Fall Semester 2023
 * Lab 6
 *
 */

package lab06_ChloeMoore;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LoopsFilesPennies {

	public static void main(String[] args) throws IOException {
		// initiate variables
		Scanner input = new Scanner(System.in);
		int days = 0; // purposefully initiated out of range - will trigger while loop (to get input)
		int pennies = 0;

		// get user input, validate it
		while (days < 21 || days > 30) {
			System.out.println("Calculate wages for how many days? (Must be an integer between 21 and 30):");
			days = input.nextInt();
		}

		// iteration loop to produce table
		System.out.println(
				"\nPay Rates for Option II vs Option I:\n\n" + "Days Worked:\tOption II (cents):\tOption I ($)");
		for (int i = 1; i <= days; i += 1) {
			if (i > 1) {
				pennies = pennies * 2;
			} else {
				pennies = 1;
			}
			if (i <= 20) {
				System.out.printf("Day %d:\t\t%,d\t\t\t%,.2f\n", i, pennies, i * 1000.);
			} else {
				System.out.printf("Day %d:\t\t%,d\t\t%,.2f\n", i, pennies, i * 1000.);
			}
		}

		// collecting the data
		double wages_pennies = pennies;
		double wages_dollars = days * 1000.;
		System.out.printf("After %d days of work, the CS major earned $%,.2f and the XX major earned $%,.2f.", days,
				wages_pennies, wages_dollars);

		///////////// commenting and file writing:

		// initiating/resetting variables and objects
		String comment = "\nThe best choice depends on the number of days worked.\n"
				+ "Working 14 days or less means the best choice is Option I\n"
				+ "(Option I earns $14,000.00 and Option II earns $8,192.00).\n"
				+ "If working 15 days or more, Option II is by far the best choice\n"
				+ "(Option I earns $15,000.00 and Option II earns $16,384.00).";
		pennies = 0;
		PrintWriter writer = new PrintWriter(new FileWriter("wages.txt", true));

		// writing the title and initial lines
		writer.print("My Comments on the Exponential Penny Pay Project"
				+ "\n\n\nPay Rates for Option II vs Option I:\n\n"
				+ "Days Worked:\tOption II (cents):\tOption I ($)\n\n");
		
		// for loop to print table
		for (int i = 1; i <= days; i += 1) {
			if (i > 1) {
				pennies = pennies * 2;
			} else {
				pennies = 1;
			}
			if (i <= 20) {
				writer.printf("Day %d:\t\t%,d\t\t\t%,.2f\n", i, pennies, i * 1000.);
			} else {
				writer.printf("Day %d:\t\t%,d\t\t%,.2f\n", i, pennies, i * 1000.);
			}
		}
		
		// writing the comment
		writer.println(comment);

		// closing shop
		writer.flush();
		writer.close();
		input.close();
	} // end main

}
