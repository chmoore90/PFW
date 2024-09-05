/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 8
 *
 */

package cMoore_lab8;

import java.util.Scanner;

public class Applications {

	public static void main(String[] args) {
		// variables
		double length;
		double width;
		Scanner keyboard = new Scanner(System.in);

		// get length and width
		System.out.println("Enter length: ");
		length = keyboard.nextDouble();
		System.out.println("Enter width: ");
		width = keyboard.nextDouble();

		// initiate rectangles
		Rectangle box = new Rectangle(length, width);
		Rectangle box2 = new Rectangle();

		// set box2 parameters
		box2.set_length(10.5);
		box2.set_width(6);

		// call display methods
		box.displayRectangle();
		box2.displayRectangle();

		// compare box and box2
		System.out.println(box.equals(box2));

		// add box3
		Rectangle box3 = new Rectangle();

		// get box parameters
		length = box.get_length();
		width = box.get_width();

		// set box3 parameters
		box3.set_length(length);
		box3.set_width(width);

		// compare box and box3
		System.out.println(box.equals(box3));

		// compute box features
		System.out.printf(
				"\tBox area: %.2f\n\tBox perimeter: %.2f\n\tBox2 area: %.2f\n\tBox2 perimeter: %.2f\n\tBox3 area: %.2f\n\tBox3 perimeter: %.2f\n",
				box.computeArea(), box.computePerimeter(), box2.computeArea(), box2.computePerimeter(),
				box3.computeArea(), box3.computePerimeter());

		// add box4
		Rectangle box4 = new Rectangle(box2);
		System.out.printf("\n\tBox4 length: %.2f\n\tBox4 width: %.2f\n", box4.get_length(), box4.get_width());
		box4.displayRectangle();
		box2.displayRectangle();

		// close scanner
		keyboard.close();
	} // end main

} // end class

/*
 * Question Comments
 * 
 * Part F: The lenghts and widths are displayed correctly, according to my
 * inputs: The length is: 5.00 The width is: 5.00 The length is: 10.50 The width
 * is: 6.00
 * 
 * Part G: Correctly displays false
 * 
 * Part K: Correctly diplays true
 * 
 * Part L: Box and Box3 are the same, since box3 has the same parameters as box.
 * Box2 has is different and corresponds to the values that are hard coded on
 * line 31 and 32. Box area: 25.00 Box perimeter: 20.00 Box2 area: 63.00 Box2
 * perimeter: 33.00 Box3 area: 25.00 Box3 perimeter: 20.00
 * 
 * Part M: Yes, box2 and box4 have the same length and width.
 */
