package lab6_ChloeMoore;

public class CarTest {

	public static void main(String[] args) {
		// create the array to hold all the cars
		Car[] car_inventory = new Car[6];

		// create 6 cars (3 new and 3 used)
		Car new_1 = new NewCar("N2312", 18000, 2006, 2000, 3000, 2000);
		Car new_2 = new NewCar("N6474", 43000, 2006, 4000, 6000, 3000);
		Car new_3 = new NewCar("N0985", 24000, 2007, 1200, 2500, 0);
		Car used_1 = new UsedCar("U5642", 16000, 2003, 400, 40000, 0.15);
		Car used_2 = new UsedCar("U1245", 8000, 1998, 700, 12000, 0.1);
		Car used_3 = new UsedCar("U9652", 18000, 2005, 2400, 12000, 0.2);

		// adding cars to inventory (new in even indexes, used in odd)
		car_inventory[0] = new_1;
		car_inventory[2] = new_2;
		car_inventory[4] = new_3;
		car_inventory[1] = used_1;
		car_inventory[3] = used_2;
		car_inventory[5] = used_3;

		// update total assets of NewCars, UsedCars, and Car dealer
		for (Car car : car_inventory) {
			car.update_assets();
		}

		// Compute and print out...
		// Total car dealer assets:
		System.out.println("Total Assets of Dealer: $" + Car.get_total_assets());

		// Total assets and avg price of NewCar:
		System.out.println("\nTotal Assets of NewCar: $" + NewCar.get_total_assets());
		System.out.println("Average New Car Price: $" + NewCar.get_total_assets() / NewCar.get_new_car_count());

		// Total assets and avg price of UsedCar:
		System.out.println("\nTotal Assets of UsedCar: $" + UsedCar.get_total_assets());
		System.out.println("Average Used Car Price: $" + UsedCar.get_total_assets() / UsedCar.get_used_car_count());

		// print out the car inventory
		System.out.println("\n");
		for (Car car : car_inventory) {
			System.out.println(car.print_out());
		}






	}

}
