package lab2;

import java.util.Random;

public class Hero {
	// data fields for hero objects
	private String name;
	private String hero_class;
	int level;
	int exp; // experience
	private static int MAX_LEVEL = 10;
	private static int[] LEVELS = {5, 10, 15, 20, 30, 40, 50, 75, 100, 150}; // exp required to next level
	Random rand = new Random(); // for generating random ints in set_random_level()


	// create new hero object with given name and default values
	public Hero(String name) {
		this.name = name;
		hero_class = "";
		level = 1;
		exp = 0;
	}

	// accessors for name, class, level
	public String get_name() {
		return name;
	}
	public String get_class() {
		return hero_class;
	}
	public int get_level() {
		return level;
	}

	// modifiers for name, class, level
	public void set_name(String n) {
		 name = n;
	}
	public void set_class(String c) {
		hero_class = c;
	}
	public void set_level(int l) {
		level = l;
	}

	// other methods
	public void set_random_level() {
		int lev = rand.nextInt(1, 11);
		level = lev;
		exp = 0;
		System.out.println(String.format("%s has been randomized to level %d", name, level));
	}

	// add new experience and level up if needed
	public void gain_exp(int e) {
		// exit method if max level already reached
		if (level == MAX_LEVEL) {
			exp = 0;
			System.out.println(String.format("%s is already at the maximum level 10.", name));
			return;
		}

		// exp calculations
		int updated_exp = exp + e;
		int required_exp = LEVELS[get_level()-1];
		int exp_difference = updated_exp - required_exp;

		// experience gain logic
		if (exp_difference < 0) { // if not enough exp to gain a level: adds to total
			exp = updated_exp;
		} else { 				  // otherwise: increase level by 1, reset exp to 0 and add leftover exp
			level += 1;
			System.out.print(String.format("%s is now level %d!\n", name, level));
			exp = 0;
			gain_exp(exp_difference);
		}
	}

	// return string with current info on hero
	public String get_info() {
		String msg = String.format("%s\n"
				+ "Class: %s\n"
				+ "Level: %d\n"
				+ "Experience: %d\n\n",
				name, hero_class, level, exp);
		return msg;
	}









}
