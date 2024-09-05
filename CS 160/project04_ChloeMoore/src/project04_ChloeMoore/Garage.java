/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 4: Parking Management
 * Description. Garage object. Stores information on the current occupancy state of each parking bay.
 *
 */

package project04_ChloeMoore;

public class Garage {
	private Car[] cars;
	private int num_cars = 0;

	public Garage(int capacity) {
		this.cars = new Car[capacity];
	}

	public Car[] get_cars() {
		return cars;
	}

	public int get_num_cars() {
		return num_cars;
	}

	public void add_car(Car car, int bay) {
		cars[bay] = car;
		num_cars += 1;
	}

	public boolean is_empty(int bay) {
		if (cars[bay] == null) {
			return true;
		} else {
			return false;
		}
	}

	public void display_cars() {
		System.out.println(cars);
		String line1 = "";
		String line2 = "";
		for (int i = 0; i < cars.length; i++) {
			line1 = line1 + i + "\t";
			String status = "empty";
			if (cars[i] != null) {
				status = "occ";
			}
			line2 = line2 + status + "\t";
		}
		System.out.println("Current garage occupancy:\n" + line1 + "\n" + line2);
	}

	public int park(Car car) {
		// check for empty bay and add car to first found
		for (int i = 0; i < cars.length; i++) {
			if (is_empty(i) == true) {
				return i;
			}
		}
		// no empties bays found
		return -1;
	}

	public double exit(int bay) {
		// calculate time elapsed
		double time = cars[bay].get_time() - System.currentTimeMillis();
		// remove car from bay
		cars[bay] = null;
		num_cars -= 1;
		// return time elapsed
		return time;
	}

	public int get_bay(int num) {
		int count = 0;
		for (int i = 0; i < cars.length; i++) {
			if (is_empty(i)) {
				continue;
			} else {
				count += 1;
			}

			if (count == num) {
				return i;
			}
 		}
		return -1;
	}
}
