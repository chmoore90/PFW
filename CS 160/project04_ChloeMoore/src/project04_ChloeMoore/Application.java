package project04_ChloeMoore;

import java.util.Random;

public class Application {

	public static void main(String[] args) {
		int capacity = 15;
		int cycles = 15;
		Garage garage = new Garage(capacity);
		Random rand = new Random();

		for (int i = 0; i < capacity; i++) {
			int randVal = rand.nextInt(0, 2);
			if (randVal == 0) {
				Car car = new Car();
				garage.add_car(car, i);
			}
		}

		Manager manager = new Manager(garage, cycles);
		manager.parking_process(cycles);
	}

}
