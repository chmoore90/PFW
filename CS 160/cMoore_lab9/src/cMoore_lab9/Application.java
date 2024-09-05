/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 9
 */

package cMoore_lab9;

public class Application {

	public static void main(String[] args) {
		// Question 1
		ArrayPractice array1 = new ArrayPractice();
		array1.display_numbers();
		array1.display_boxes();
		// Works as expected. Numbers values are integers between -100 and 100. Box
		// parameters are doubles between 0 and 1.

		// Question 2
		String[] list = { "Pippin", "Kalos", "Winnie", "Robbie", "Beanie", "Biddy" };

		// Question 3
		ArrayPractice array2 = new ArrayPractice(50, 6, list);
		
		// Question 4
		array2.display_numbers();
		array2.display_boxes();
		array2.display_list();
		// As expected. 50 integers, 6 boxes, and the list of 6 names.
	}

}
