/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023
 * Project 4: Parking Management
 * Description. Preforms operations of the garage (manages cars entering and exiting)
 *
 */

package project04_ChloeMoore;

import java.util.Random;

import javax.swing.JOptionPane;

public class Manager {
	private final static double FEE_PER_HOUR = 1.5;
	private Garage garage;
	private double total_fees;
	private String title = "Garage Manager";
	private Random rand = new Random();

	public Manager(Garage garage, int limit) {
		this.garage = garage;
	}

	public void car_parks() {
		Car car = new Car();
		int index = garage.park(car);
		if (index != -1) {
			garage.add_car(car, index);
			garage.display_cars();
			JOptionPane.showMessageDialog(null,
					String.format(
							"A car is entering bay #%d.\nThe updated garage occupancy is displayed on the console.",
							index),
					title, JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println(String.format("Total parking fees collected: $%,.2f", Math.abs(total_fees)));
			JOptionPane.showMessageDialog(null, "The parking garage is full.\nApplication will now close.", title,
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	public void car_exits() {
		int num_cars = garage.get_num_cars();

		if (num_cars > 0) {
			int rand_num;
			if (num_cars == 1) {
				rand_num = 1;
			} else {
				rand_num = rand.nextInt(1, num_cars);
			}
			int bay = garage.get_bay(rand_num);
			double time = garage.exit(bay);
			double fee = time * FEE_PER_HOUR / 1000.00;
			total_fees += fee;
			garage.display_cars();
			JOptionPane.showMessageDialog(null,
					String.format(
							"A car is exiting from bay #%d. Their parking fee is $%,.2f.\nThe updated garage occupancy is displayed on the console.",
							bay, Math.abs(fee)),
					title, JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println(String.format("Total parking fees collected: $%,.2f", Math.abs(total_fees)));
			JOptionPane.showMessageDialog(null, "The parking garage is empty.\nApplication will now close.", title,
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	public void parking_process(int limit) {
		garage.display_cars();
		JOptionPane.showMessageDialog(null,
				"Welcome to the parking garage simulator!\nA parking garage has been generated and is displayed in the console.",
				title, JOptionPane.INFORMATION_MESSAGE);
		for (int i = 0; i < limit; i++) {
			if (rand.nextInt(0, 2) == 0) {
				car_parks();
			} else {
				car_exits();
			}
		}
		System.out.println(String.format("Total parking fees collected: $%,.2f", Math.abs(total_fees)));
		JOptionPane.showMessageDialog(null,
				String.format("You've reached the limit of %d cycles.\nApplication will now close.", limit), title,
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
