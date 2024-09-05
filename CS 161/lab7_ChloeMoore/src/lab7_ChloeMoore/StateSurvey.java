package lab7_ChloeMoore;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StateSurvey {

	public static void main(String[] args) throws InvalidStateException, InvalidZipException, IOException {
		try {

		// instantiate scanner for user input and array for states
		Scanner scanner = new Scanner(System.in);
		String[][] states = new String[50][2];

		// get user age
		int user_age = get_age(scanner);

		// get and validate the file name (continue requesting name until a valid one is entered)
		String file_name = "";
		boolean validate = false;

		while (!validate) {
			System.out.println("Please enter the name of a file you'd like to open: ");
			file_name = scanner.next();
			validate = validate_file_name(file_name);
		}

		// read file information and store is states array
		String file_path = String.format("src\\lab7_ChloeMoore\\%s", file_name);
		DataInputStream input_file = new DataInputStream(new FileInputStream(file_path));
		read_file(input_file, states);

		// get state abbrev from user and validate it
		String user_state;
		while (true) {
			try {
				user_state = get_state(scanner, states);
			} catch (InvalidStateException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}

		// get user's zip code and validate
		int user_zip = -1;
		while (true) {
			try {
				user_zip = get_zip(scanner);
			} catch (InvalidZipException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}

		// display all the user's information
		String full_state_name = "";
		for (int i = 0; i < 50; i++) {
			if (states[i][0].equals(user_state)) {
				full_state_name = states[i][1];
				break;
			}
		}

		String msg = String.format("OUTPUT\nYour age: %d\nYour state and zip: %s %d.", user_age, full_state_name, user_zip);
		System.out.println(msg);

		// close scanner
		scanner.close();
	} finally {
		System.out.println("Thank you for your participation.");

	}
	}

	public static int get_age(Scanner scanner) {
		int user_age = -1;
		System.out.println("Please enter your age (or \"quit\" to exit): ");

		try {
		// if user enters anything other than an integer, exception will trigger
			user_age = scanner.nextInt();
		}
		catch (Exception e) {
		// exists program if integer was not entered
			System.out.println("You've chosen to quit before entering your age. Thank you for your time.");
			System.exit(0);
		}

		return user_age;
	}

	public static boolean validate_file_name(String file_name) {
		try {
			File file = new File(String.format("src\\lab7_ChloeMoore\\%s", file_name));
			return file.exists();

		} catch (Exception e) {
			return false;

		} finally {
			if (file_name.toLowerCase().equals("quit")) {
				System.out.println("You've chosen quit before entering a file name. Thank you for your time.");
				System.exit(0);
			}
		}
	}

	public static void read_file(DataInputStream file, String[][] states) throws IOException {
		int count = 0;

		while (true) {
			try {
				String word = file.readUTF();
				if (word.length() == 2) {
					states[count][0] = word.strip();
				} else {
					states[count][1] = word.strip();
					count += 1;
				}
			} catch (EOFException e) {
				break;
			}
		}
	}

	public static String get_state(Scanner scanner, String[][] states) throws InvalidStateException {
		while (true) {
			System.out.println("Please enter a 2 letter state abbreviation: ");
			String user_state = scanner.next().toUpperCase().strip();

			if (user_state.length() != 2) {
				throw new InvalidStateException();
			}

			for (int i = 0; i < states.length; i++) {
				if (states[i][0].equals(user_state)) {
					return user_state;
				}
			}

			throw new InvalidStateException(user_state);
		}
	}

	public static int get_zip(Scanner scanner) throws InvalidZipException {
		while (true) {
			System.out.println("Please enter your 5 digit zip code:");
			String user_zip = scanner.next();

			if (user_zip.length() != 5) {
				throw new InvalidZipException();
			}

			for (int i = 0; i < 5; i++) {
				char c = user_zip.charAt(i);
				if (!Character.isDigit(c)) {
					throw new InvalidZipException();
				}
			}

			int zip = Integer.parseInt(user_zip);
			return zip;
		}
	}

}
