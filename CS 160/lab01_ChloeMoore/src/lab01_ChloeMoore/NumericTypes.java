package lab01_ChloeMoore;

import java.util.Scanner;

/*
* Chloe Moore
* CS 16000-01-03, Fall Semester 2023 
* Lab 01
*
*/

public class NumericTypes {

	public static void main(String[] args) {
		// declare variables
		byte byteNumber = 127;
		short shortNumber = 127;
		int intNumber = 127;
		long longNumber = 127;
		float floatNumber = 127;
		double doubleNumber = 127;

		String pbmTitle = "For problem 2(A): ";
		String output = "\n\tbyteNumber = " + byteNumber + "\n\tshortNumber = " + shortNumber + "\n\tintNumber = "
				+ intNumber + "\n\tlongNumber = " + longNumber + "\n\tfloatNumber = " + floatNumber
				+ "\n\tdoubleNumber = " + doubleNumber;
		System.out.println(pbmTitle + output); // Testing output of initial values;

		// call method
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner
		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Enter the integer 123 six times: ");
		byteNumber = keyboardInput.nextByte();
		shortNumber = keyboardInput.nextShort();
		intNumber = keyboardInput.nextInt();
		longNumber = keyboardInput.nextLong();
		floatNumber = keyboardInput.nextFloat();
		doubleNumber = keyboardInput.nextDouble();

		// print new variables for 2(B)
		pbmTitle = "For problem 2(B): ";
		output = "\n\tbyteNumber = " + byteNumber + "\n\tshortNumber = " + shortNumber + "\n\tintNumber = " + intNumber
				+ "\n\tlongNumber = " + longNumber + "\n\tfloatNumber = " + floatNumber + "\n\tdoubleNumber = "
				+ doubleNumber;
		System.out.println(pbmTitle + output);

		// call method again for 2(B)
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);
		/**
		 * The numbers are difference in parts A and B because the scanner inputs
		 * reassigned the variables. I didn't notice a difference when using println()
		 * and displayConsole().
		 */

		//// Question 3
		intNumber = 127;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// print new variables for 3(A)
		pbmTitle = "For problem 3(A): ";
		output = "\n\tbyteNumber = " + byteNumber + "\n\tshortNumber = " + shortNumber + "\n\tintNumber = " + intNumber
				+ "\n\tlongNumber = " + longNumber + "\n\tfloatNumber = " + floatNumber + "\n\tdoubleNumber = "
				+ doubleNumber;
		System.out.println(pbmTitle + output);

		// call method again for 3(A)
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 3(B)
		System.out.println("Enter the integer 127: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// print new variables for 3(B)
		pbmTitle = "For problem 3(B): ";
		output = "\n\tbyteNumber = " + byteNumber + "\n\tshortNumber = " + shortNumber + "\n\tintNumber = " + intNumber
				+ "\n\tlongNumber = " + longNumber + "\n\tfloatNumber = " + floatNumber + "\n\tdoubleNumber = "
				+ doubleNumber;
		System.out.println(pbmTitle + output);

		// call method again for 3(B)
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// Question 4
		//// part a: 128
		intNumber = 128;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4a: 128 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(B)
		System.out.println("Enter the integer 128: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4a: 128 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part b: 129
		intNumber = 129;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4b: 129 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(B)
		System.out.println("Enter the integer 129: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4b: 129 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part c: -128
		intNumber = -128;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4c: -128 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(C)
		System.out.println("Enter the integer -128: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4c: -128 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part d: -129
		intNumber = -129;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4d: -129 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(D)
		System.out.println("Enter the integer -129: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4d: -129 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part e: 32767
		intNumber = 32767;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4e: 32767 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(E)
		System.out.println("Enter the integer 32767: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4e: 32767 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part f: 32768
		intNumber = 32768;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4f: 32768 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(F)
		System.out.println("Enter the integer 32768: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4f: 32768 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part g: -32768
		intNumber = -32768;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4g: -32768 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(G)
		System.out.println("Enter the integer -32768: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4g: -32768 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part h: -32769
		intNumber = -32769;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4h: -32769 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(H)
		System.out.println("Enter the integer -32769: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4h: -32769 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part i: 2147483647
		intNumber = 2147483647;
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4i: 2147483647 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(I)
		System.out.println("Enter the integer 2147483647: ");
		intNumber = keyboardInput.nextInt();
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4i: 2147483647 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		//// part j: 2147483648
		intNumber = (int) 2147483648f; // corrected by add "f" to indicate float, and casting to int type
		byteNumber = (byte) intNumber;
		shortNumber = (short) intNumber;
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4j: 2147483648 (hard coded)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);

		// scanner input for 4(J)
		System.out.println("Enter the integer 2147483648: ");
		intNumber = (int) keyboardInput.nextFloat(); // corrected by asking for next float, then casting to int
		byteNumber = (byte) intNumber; // corrected by casting
		shortNumber = (short) intNumber; // corrected by casting
		longNumber = intNumber;
		floatNumber = intNumber;
		doubleNumber = intNumber;

		// call method to display
		pbmTitle = "Question 4j: 2147483648 (scanner)";
		displayConsole(pbmTitle, byteNumber, shortNumber, intNumber, longNumber, floatNumber, doubleNumber);
		/**
		 * Questions 3 and 4 comments: I didn't see any difference between hard coding
		 * the integer values and using the scanner. Bytes and shorts cannot be
		 * converted to integers, they needed casting each time. I resolved 4j (the
		 * input was out of range) by putting a "f" after the number to make it a float.
		 * I also cast it to an integer, so I had the correct type again. Because of the
		 * cast, the input was truncated and the computer was actually using a smaller
		 * value. This makes sense because the results from part I and part J were the
		 * same, indicating it was using the same value for both.
		 */

		//// Question 5
		floatNumber = 69;
		System.out.println(floatNumber); // result: 69.0

		floatNumber = 69.0f; // corrected by adding "f" to change to float
		System.out.println(floatNumber); // result: 69.0

		floatNumber = 69.68f; // corrected by adding "f" to change to float
		System.out.println(floatNumber); // result: 69.68
		/**
		 * Working with floats allows for much more precision.
		 */

		//// Question 6
		intNumber = 825;
		doubleNumber = 751;

		double ratio = intNumber / 751;
		System.out.println(ratio);
		System.out.printf("%.4f\n", ratio);

		ratio = intNumber / doubleNumber;
		System.out.println(ratio);
		System.out.printf("%.3f\n", ratio);
		/**
		 * 1.0000 - intNumber/751 gives an integer answer of 1. Because ratio is a
		 * double, we can add extra decimal places to the 1. 1.098535... -
		 * intNumber/doubleNumber gives a double answer, which allows much more
		 * precision. 1.099 - double is rounded to 3 decimal places.
		 */

		//// Question 7
		System.out.println('a' + 'b');
		System.out.println(" " + 'a' + 'b');
		System.out.println(" " + ('a' + 'b'));
		System.out.println((" " + 'a' + 'b'));
		System.out.println((" " + 'a') + 'b');
		System.out.println(' ' + 'a' + 'b');
		System.out.println(' ' + ('a' + 'b'));
		System.out.println((' ' + 'a' + 'b'));
		System.out.println((' ' + 'a') + 'b');
		/**
		 * When computing characters encased ONLY in single quotes, program prints ASCII
		 * characters. When using double quotations or a mix of both, program treats it
		 * as a string.
		 */

		//// Question 8
		System.out.println("These are numbers: " + intNumber + " and " + doubleNumber);
		System.out.println("These are numbers: " + intNumber + doubleNumber);
		System.out.println("These are numbers: " + (intNumber + doubleNumber));
		/**
		 * line 1: + sign connects strings and numbers together line 2: + sign connects
		 * strings and numbers togehter. No spaces added automatically. line 3: + sign
		 * used mathematically because numbers were isolated by parentheses.
		 */

		//// Question 9
		System.out.println("Formula1: " + (25 + 5 / intNumber * doubleNumber + 1) + "\nFormula2: " + 25
				+ 5 / intNumber * doubleNumber + 1 + "\nFormula3: " + (25 + 5) / intNumber * (doubleNumber + 1)
				+ "\nFormula4: " + ((25 + 5) / intNumber * (doubleNumber + 1)) + "\nFormula5: "
				+ ((25 + 5) / intNumber * doubleNumber + 1) + "\nFormula6: " + (25 + 5) / intNumber * doubleNumber + 1);
		/**
		 * Can easily organize printing multiple lines. Simply add a "+" to the end of a
		 * line. Also added "\n" to the beginning of the second line onwards so each
		 * formula had its own line.
		 */

		// close keyboard
		keyboardInput.close();

	}// end of main

	public static void displayConsole(String pbm, byte bN, short sN, int iN, long lN, float fN, double dN) {
		String output = "\n\tbyteNumber = " + bN + "\n\tshortNumber = " + sN + "\n\tintNumber = " + iN
				+ "\n\tlongNumber = " + lN + "\n\tfloatNumber = " + fN + "\n\tdoubleNumber = " + dN;
		System.out.println(pbm + output);
	}// end of displayConsole

}// end of class NumericTypes
