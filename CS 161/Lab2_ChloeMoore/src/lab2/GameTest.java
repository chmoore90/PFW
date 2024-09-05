package lab2;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// new party object
		Party party = new Party();
		
		// String array for hero classes
		String[] hero_classes = {"mage", "rogue", "druid", "ranger", "knight"};
		
		// initiating some heroes
		Hero laudrei = new Hero("Laudrei of Exodar");
		Hero mal = new Hero("Mal Volari");
		Hero verity = new Hero("Verity Starbird");
		Hero fiel = new Hero("Fiel Rys");
		Hero diavolos = new Hero("Diavolos Nevrakis");
	
		Hero[] all_heroes = {laudrei, mal, verity, fiel, diavolos};
		
		// list classes to console
		System.out.println("The available classes are:");
		for (String hero_class : hero_classes) {
			System.out.println(hero_class);
		}
		
		System.out.println();
		
		// assigning classes for the our heroes
		Scanner console = new Scanner(System.in);
		for (Hero hero : all_heroes) {
			String name = hero.get_name();
			boolean validation = false;

			// get user input, check validity, set hero class (loop only ends when valid match is found)
			while (!validation) {
				System.out.println(String.format("Enter a class for %s:", name));
				String user_input = console.next().toLowerCase();
				validation = validate_input(user_input, hero_classes);
				hero.set_class(user_input);
			}
		}
		
////////// The adventure begins! (ie testing stuff)
		System.out.print("\nTHE ADVENTURE BEGINS!\n");
		
		party.add_hero(0, fiel);
		party.add_hero(1, diavolos);
		party.add_hero(2, verity);
		party.print_party();
		
		System.out.print("The party encountered some orc scouts... and defeated them!\n");
		
		party.gain_exp(10);
		party.print_party();
		
		System.out.print("In order to infiltrate the nearby orc encampment, they'll need the help of a stealthy rogue...\n");
		
		party.add_hero(1, mal); // (depending on what classes you assigned, Mal might not actually be a rogue... so just pretend)
		party.print_party();
		
		System.out.print("While investigating the camp, Mal and Verity successfully snoop around, but Fiel is discovered and captured!\n");

		party.remove_hero(0);
		party.gain_exp(25);
		party.print_party();
		
		System.out.print("To rescue Fiel, the group recruits a powerful ally...\n");
		
		laudrei.set_random_level();
		party.add_hero(2, laudrei);
		party.print_party();
		
		System.out.print("After a hard-fought battle, the orcs are defeated and Fiel is saved!\n");
		
		party.add_hero(0, fiel);
		party.gain_exp(100);
		party.print_party();
		
		// close scanner
		console.close();
	}
		
		// method for validating user input for classes by comparing input to list of valid classes
		public static boolean validate_input(String user_in, String[] hero_classes) {
			for (String h_class : hero_classes) {
				if (h_class.equals(user_in)) { // end loop if match found, return true
					return true;
				} else { // go to next class if match not found
					continue;
				}	
			}
			// print error message and return false if no matches found
			System.out.println("That is not a valid class. Try again.");
			return false;
		}
	}