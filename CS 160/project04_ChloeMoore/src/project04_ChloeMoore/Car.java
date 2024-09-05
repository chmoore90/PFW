/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 4: Parking Management
 * Description. Car object. Stores arrival time
 *
 */

package project04_ChloeMoore;

public class Car {
	private long time_in;

	public Car() {
		this.time_in = System.currentTimeMillis();
	}

	public long get_time() {
		return time_in;
	}
	
}
