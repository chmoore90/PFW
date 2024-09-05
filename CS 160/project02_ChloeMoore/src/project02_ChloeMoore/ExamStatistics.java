/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 2: Examination Statistics
 *
 * Description: Analyzes examination statistics from a file input by the user. Returns a summary of the results.
 *
 */

package project02_ChloeMoore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamStatistics {

	static final int GRADE_A = 90;
	static final int GRADE_B = 80;
	static final int GRADE_C = 65;
	static final int GRADE_D = 50;

	public static void main(String[] args) throws FileNotFoundException {
		// Declare variables
		int count_a = 0;
		int count_b = 0;
		int count_c = 0;
		int count_d = 0;
		int count_f = 0;
		int count_all = 0;
		int count_valid = 0;
		int min_score = 101; // will be overwritten (out of range)
		int max_score = -1; // ditto
		int score;
		double sum = 0;
		double average;
		double psd = 0;
		double psd_sum = 0;
		var score_list = new ArrayList<Integer>(); // needed for the for loop to calculate psd
		String message;

		// Declare and instantiate a Scanner object for console reading
		Scanner user_input = new Scanner(System.in);

		// Declare and instantiate a File object to the file name solicited and received
		// from the console
		System.out.println("Enter the name of the file you want to read: ");
		String file_path = user_input.nextLine();
		File file = new File(file_path);

		// Check if the file exists and repeat file name solicitation until the name is
		// accepted (a loop will be used)
		while (!file.exists()) {
			System.out.println("Your previous entry was not valid. Enter the name of the file you want to read (don't forget .txt): ");
			file_path = user_input.nextLine();
			file = new File(file_path);
		}

		// Declare and instantiate another Scanner object reader to read data from the
		// file
		Scanner reader = new Scanner(file);

		// Run a while loop to read, count, and sum the scores (“running total”); the
		// loop must also have logic to determine
		// maxScore, and minScore, and must count the occurrences of scores in the grade
		// groups; input values are checked,
		// wrong input is not counted and they are ignored in the processing (the
		// loop continues at the next iteration if
		// wrong input was found). Wrong input does not update any of the counter
		// variables, nor the sum, maxScore, and minScore variables.

		while (reader.hasNext()) {
			score = reader.nextInt();
			count_all += 1;

			// validate score
			if (score < 0 || score > 100) {
				continue;
			}

			// update counters
			if (score >= GRADE_A) {
				count_a += 1;
				count_valid += 1;
			} else if (score >= GRADE_B) {
				count_b += 1;
				count_valid += 1;
			} else if (score >= GRADE_C) {
				count_c += 1;
				count_valid += 1;
			} else if (score >= GRADE_D) {
				count_d += 1;
				count_valid += 1;
			} else {
				count_f += 1;
				count_valid += 1;
			}

			// compare to min/max values
			if (score < min_score) {
				min_score = score;
			} else if (score > max_score) {
				max_score = score;
			}

			// add score to sum and list
			sum += score;
			score_list.add(score);

		}
		// Compute the average
		average = Double.valueOf(sum / count_valid);

		// Re-instantiate the file reader Scanner object
		//// Skipped this step because I made a a list that added the scores using the
		// while loop

		// Run a for loop that makes the summation for psd, see the formula for psd
		for (int n : score_list) {
			psd_sum = psd += Math.sqrt(Math.pow((average - n), 2));
		}

		// Compute psd
		psd = psd_sum / count_valid;

		// Compose the output message
		message = String.format(
				"Exam Statistics\n\n\n" + "Total number of (given) scores: %d\n"
						+ "Total number of valid scores: %d\n\n" + "Considering only the valid scores:\n\n"
						+ "Average score: %.2f\n" + "Population standard deviation: %.2f\n\n"
						+ "# of A, 90-100: \t %d \t %.2f%%\n" + "# of B,  80-89: \t %d \t %.2f%%\n"
						+ "# of C,  65-79: \t %d \t %.2f%%\n" + "# of D,  50-64: \t %d \t %.2f%%\n"
						+ "# of F,   0-49: \t %d \t %.2f%%\n\n" + "Minimum score: %d\n" + "Maximum score: %d",
				count_all, count_valid, average, psd, count_a, Double.valueOf(count_a) / count_valid * 100, count_b,
				Double.valueOf(count_b) / count_valid * 100, count_c, Double.valueOf(count_c) / count_valid * 100,
				count_d, Double.valueOf(count_d) / count_valid * 100, count_f,
				Double.valueOf(count_f) / count_valid * 100, min_score, max_score);

		// Display the message on the console
		// also print to a file
		System.out.println("Enter a name for the new file (don't forget the .txt!):");
		String new_file = user_input.nextLine();
		PrintWriter output = new PrintWriter(new_file);
		output.println(message);
		System.out.println(message);

		output.flush();
		output.close();
		user_input.close();
		reader.close();
	} // main

}
