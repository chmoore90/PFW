package lab2;

public class Party {
	// array for heroes in the party
	private Hero[] heroes;
	
	// create a Party that can hold 3 heroes
	public Party() {
		heroes = new Hero[3];
	}
	
	// add or replace a hero at the index with a new hero
	public void add_hero(int index, Hero hero) {
		heroes[index] = hero;
	}
	
	// remove and return hero at given index
	public Hero remove_hero(int index) {
		Hero hero = heroes[index];
		heroes[index] = null;
		
		return hero;
	}
	
	// get hero at given index
	public Hero get_hero(int index) {
		return heroes[index];
	}
	
	// gain experience for all party members
	public void gain_exp(int exp) {
		System.out.println(String.format("The party gains %d experience.", exp));
		for (Hero hero : heroes) {
			if (hero != null) {
				hero.gain_exp(exp);
			} else { // skips if hero is null
				continue;
			}
		}
	}
	
	// print out party info
	public String print_party() {
		String msg = "\n----- Current party -----\n";
		for (Hero hero : heroes) {
			if (hero != null) {
				msg = msg + hero.get_info();
			} else { // skips if hero is null
				continue;
			}
		}
		
		System.out.println(msg);
		return msg;
		}
	}
	
