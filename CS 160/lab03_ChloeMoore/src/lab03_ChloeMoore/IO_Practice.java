/**
 * Chloe Moore
 * CS 16000-01 – 003 Fall Semester 2023 
 * Lab 3
*/

package lab03_ChloeMoore;

// Problem 1: import external classes
import java.util.Scanner; //required for Scanner class.
import javax.swing.JOptionPane; //required for JOptionPane class.

public class IO_Practice {

	public static void main(String[] args) {
		// Problem 2: declare variables
		int numberOfBooks, titleLength, yearPublished, thisYear;
		double unitPrice, totalCost;
		String authorName, bookTitle, publisher, edition, firstName, middleName, lastName;
		char middleInitial;
		String cFirstName, cMiddleName, cLastName;// customer's name.
		String streetAddress, cityName, stateName, zipCode;

		// Problem 3. Declare and instantiate a Scanner object that can read data from
		// the console
		Scanner keyboardInput = new Scanner(System.in);

		// Problem 4. Solicit and read an integer value from the console (you choose the
		// input). Store the input in variable numberOfBooks
		System.out.println("Number of books to order: ");
		numberOfBooks = keyboardInput.nextInt();

		// Problem 5. Solicit and read a number with a decimal point from the console
		// (you choose the input). Store the input in variable unitPrice
		System.out.println("Unit price of the book(s): ");
		unitPrice = keyboardInput.nextDouble();

		// Problem 6. Output total cost of books
		totalCost = unitPrice * numberOfBooks;
		System.out.printf("The total cost of %d books with a unit price of $%.2f is $%.2f\n", numberOfBooks, unitPrice,
				totalCost);

		// Problem 7. Solicit the customer’s name, then address on the console.
		System.out.println("\nEnter the customer's first name, middle name and last name: ");
		cFirstName = keyboardInput.next().toUpperCase();
		cMiddleName = keyboardInput.next().toUpperCase();
		cLastName = keyboardInput.next().toUpperCase();

		keyboardInput.nextLine(); // consume the remaining line.

		System.out.println("Enter the customer's street address(i.e. house number and street name): ");
		streetAddress = keyboardInput.nextLine();
		System.out.println("Enter name of the city: ");
		cityName = keyboardInput.nextLine();
		System.out.println("Enter name of the state: ");
		stateName = keyboardInput.nextLine();
		System.out.println("Enter the Zip Code: ");
		zipCode = keyboardInput.nextLine();
		System.out.println("\nName:\t" + cFirstName + " " + cMiddleName + " " + cLastName);
		System.out.printf("Street Address:\t%s\nCity:\t%s\tState:\t%s\nZipCode:\t%s\n", streetAddress, cityName,
				stateName, zipCode);

		// Problem 8 & 9. Solicit the name of your favorite author on the console
		System.out.println("\nEnter the first, middle, and last name of your favourite author: ");
		firstName = keyboardInput.next();
		middleName = keyboardInput.next();
		lastName = keyboardInput.next();

		// Problem 10. Extract middle initial
		middleInitial = middleName.charAt(0);

		// Problem 11. Re-assign all characters of the lastName to be all uppercase
		lastName = lastName.toUpperCase();

		// Problem 12. Re-build the author’s name to be of the format: (last name (all
		// in uppercase), first name middle initial.)
		authorName = String.format("%s, %s %c", lastName, firstName, middleInitial);
		System.out.printf("Author name: %s", authorName);

		// Problem 13 & 14. Solicit the title of your favorite book on the console.
		System.out.println("\n\nEnter the title of your favourite book: ");
		keyboardInput.nextLine();
		bookTitle = keyboardInput.nextLine();
		bookTitle = bookTitle.toUpperCase();

		// Problem 15. And find the length of the book title and store it in the
		// variable titleLength.
		titleLength = bookTitle.length();
		System.out.printf("Book title (with length) is: %s (%d)", bookTitle, titleLength);

		// Problem 16. Solicit the name of the publisher, edition, year published, and
		// current year. Store them as the appropriate variables
		System.out.println("\n\nEnter the name of the book's publisher: ");
		publisher = keyboardInput.nextLine();
		System.out.println("Enter the edition of the book: ");
		edition = keyboardInput.nextLine();
		System.out.println("Enter the year the book was published: ");
		yearPublished = keyboardInput.nextInt();
		System.out.println("Enter the current year: ");
		thisYear = keyboardInput.nextInt();

		// Problem 17. To the console, print the author’s name (lastName(upper case),
		// firstName Initial), the bookTitle of the book (upper case), followed by the
		// publisher, edition and year published. Then the length of the title and age
		// of the book
		System.out.println("\nInformation about the customer's favorite book:");
		System.out.printf("The customer's favorite author is:\n\t%s\n", authorName);
		System.out.printf("The customer's favorite book from %s is \n\t%s,\n", firstName, bookTitle);
		System.out.printf("\t%s, %s Edition, %d.\n", publisher, edition, yearPublished);
		System.out.printf("The length of the title is: %s.\n", titleLength);
		if ((thisYear - yearPublished) < 1) {
			System.out.println("It is a year old book\n");
		} else if (thisYear - yearPublished < 160) {
			System.out.printf("It is a %d years old book\n", (thisYear - yearPublished));
		} else {
			System.out.println("It is a 160 years old book\n");
		}

		// Problem 18. Print the result of the order for the book to console
		if (numberOfBooks > 1) {

			System.out.printf("\nThe total cost of %d books of unit price $%.2f is $%.2f\nfrom the publisher %s.\n",
					numberOfBooks, unitPrice, totalCost, publisher);
		} else {
			System.out.printf("The total cost of %d book of unit price $%.2f is $%.2f\nfrom the publisher %s.\n",
					numberOfBooks, unitPrice, totalCost, publisher);
		}

		// Problem 19. Use the JOptionPane input dialog box to prompt whether would like
		// to re-order the book. If yes, Use the JOptionPane input dialog boxes to enter
		// the number of the book to be re-ordered and enter the unit price of the book.

		numberOfBooks = 0; // initial assumption of no books reordered
		int order = JOptionPane.showConfirmDialog(null, "Do you want to reorder the book?", "Reorder?",
				JOptionPane.YES_NO_OPTION);
		if (order == JOptionPane.YES_OPTION) {
			String input = JOptionPane.showInputDialog("How many books would you like to reorder?: ");
			numberOfBooks = Integer.parseInt(input);
			input = JOptionPane.showInputDialog("Enter the unit price of the book: ");
			unitPrice = Double.parseDouble(input);
			totalCost = numberOfBooks * unitPrice;

			// Problem 20. Information about Customer
			System.out.println("\nInformation about Customer:");
			System.out.printf("Name:\t%s %s %s\n", cFirstName, cMiddleName, cLastName);
			System.out.printf("Street Address:\t%s\nCity:\t%s\nState:\t%s\nZipCode:  %s\n", streetAddress, cityName,
					stateName, zipCode);
			// if statements to determine output message
			if (numberOfBooks > 1) {
				System.out.printf("\nThe total cost for reordering %d books of unit price $%.2f: $%.2f, from %s",
						numberOfBooks, unitPrice, totalCost, publisher);
			} else {
				System.out.printf("\nThe total cost for reordering %d book of unit price $%.2f: $%.2f, from %s",
						numberOfBooks, unitPrice, totalCost, publisher);
			}
			System.out.println("\n\nThe end of the invoice.");
		} else {
			System.out.println("There is no reorder of book.");
		}
		
		// close the scanner
		keyboardInput.close();
		
		System.exit(0);
	}// end of main

}
