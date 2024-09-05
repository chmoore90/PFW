/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 10
 */

package lab10_ChloeMoore;

import java.util.Random;

public class Application {

	public static void main(String[] args) {
		// variables
		final int size = 12;
		String[] senders = { "Kalos", "Pippin", "Winnie", "Robbie", "Beanie", "Biddy", "Marge", "Little Bit", "Mr. Oranges", "Max", "Bruich", "Shaka" };
		boolean[] print_status = new boolean[size];
		Letter[] letters = new Letter[size];
		Random rand = new Random();

		// generating values for print_status boolean list
		for (int i = 0; i < print_status.length; i++) {
			int random = rand.nextInt(0,2);
			if (random == 0) {
				print_status[i] = true;
			} else {
				print_status[i] = false;
			}
		}

		// generating letters for the letter array
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new Letter(senders[i], print_status[i]);
		}

		// generating the PO box and box clone
		int new_num = rand.nextInt(10001, 99999);
		POBox box = new POBox(letters, new_num);

		POBox box_clone = new POBox(box);

		// first entries exactly equal?
		boolean result1 = box.get_Letters()[0] == box_clone.get_Letters()[0];
		System.out.println("Are box and box clone deep clones?: " + result1 + "\n");

		// printing out the boxes
		String title1 = String.format("Box\nNumber: %d\nSender\t\tPrint Status\n", box.get_box_num());
		String title2 = String.format("\n\nBox Clone\nNumber: %d\nSender\t\tPrint Status\n", box_clone.get_box_num());
		System.out.println(title1 + box.get_box_vars() + title2 + box_clone.get_box_vars());

		// are the first entries functionally equal?
		boolean result2 = box.get_Letters()[0].equals(box_clone.get_Letters()[0]);
		System.out.println("Are box and box clone functionally equal?: " + result2 + "\n");
	}

}
