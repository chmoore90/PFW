/*
 * Chloe Moore
 * CS 16000-01 – 03, Fall Semester 2023 
 * Project 1: Compute the Projectile Motion
 *
 * Description. Targeting simulation.
 *
 */

package project01_ChloeMoore;

import javax.swing.JOptionPane; //Need for JOptionPane class.

public class MissileInMotion {

	public static void main(String[] args) {
		// declare initial variables
		final int GRAVITATION = 32;

		//// ****************************************** FIRST ATTEMPT
		String attempt = "";

		// get user input and assign to variables
		final double distanceToTarget = Double
				.parseDouble(JOptionPane.showInputDialog("Enter distance to target in feet:"));
		double initialVelocity = Double
				.parseDouble(JOptionPane.showInputDialog("Enter initial velocity in feet/second:"));
		double launchAngle = Double.parseDouble(JOptionPane.showInputDialog(
				"Enter initial launch angle in feet/second:\n(Initial launch angle must be 45 degrees)"));

		// VALIDATION STEP: check initial launch angle is 45
		if (launchAngle != 45) {
			JOptionPane.showMessageDialog(null,
					"Failed to enter 45 degrees on first attempt.\nPlease restart and try again with an initial launch angle of 45 degrees.",
					"Input Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// run calculations via called methods
		double radian = convertRadians(launchAngle);
		double flightTime = calcFlightTime(initialVelocity, radian, GRAVITATION);
		double highestPoint = calcHighestPoint(flightTime, initialVelocity, radian, GRAVITATION);
		double distanceTraveled = calcDistanceTraveled(flightTime, initialVelocity, radian);
		double error = distanceToTarget - distanceTraveled;

		// set minError to initial error value
		double minError = error;

		// VALIDATION STEP: check target is in range
		if (distanceTraveled < distanceToTarget - 1) {
			JOptionPane.showMessageDialog(null,
					"The target is too far away!\nPlease restart and try again with a greater initial velocity.",
					"Range Alert", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

		// check for a hit
		if (Math.abs(error) < 1) {
			JOptionPane.showMessageDialog(null, "\n\n\tA hit!\nYour shot landed within 1 foot of the target.");
			System.out.printf("\nYour best shot was within %.2f feet of the target.", minError);
			System.exit(0);
		}

		// output data
		String trajectory = "Initial velocity: %.2f feet/second\n" + "Launch angle: %.2f degrees\n"
				+ "Flight time: %.2f seconds\n" + "Maximum height: %.2f feet\n" + "Distance traveled: %.2f feet\n"
				+ "Missed target by: %.2f feet";
		System.out.printf(trajectory, initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled,
				Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		// error analysis
		errorAnalysis(attempt, error, minError, launchAngle);

		//// **********************************************SECOND ATTEMPT
		attempt = "Second Attempt";

		// get new angle input
		launchAngle = getAngle(attempt);

		// recalculate values
		radian = convertRadians(launchAngle);
		flightTime = calcFlightTime(initialVelocity, radian, GRAVITATION);
		highestPoint = calcHighestPoint(flightTime, initialVelocity, radian, GRAVITATION);
		distanceTraveled = calcDistanceTraveled(flightTime, initialVelocity, radian);
		error = distanceToTarget - distanceTraveled;

		// check minError is smallest
		if (Math.abs(error) < Math.abs(minError)) {
			minError = error;
		}

		// check for a hit
		if (Math.abs(error) < 1) {
			JOptionPane.showMessageDialog(null,
					"A hit!\nYour shot landed within 1 foot of the target.\nThe program will now close.");
			System.out.printf("\nYour best shot was within %.2f feet of the target.", minError);
			System.exit(0);
		}

		// output data
		trajectory = "Initial velocity: %.2f feet/second\n" + "Launch angle: %.2f degrees\n"
				+ "Flight time: %.2f seconds\n" + "Maximum height: %.2f feet\n" + "Distance traveled: %.2f feet\n"
				+ "Missed target by: %.2f feet";
		System.out.printf(trajectory, initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled,
				Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		// error analysis
		errorAnalysis(attempt, error, minError, launchAngle);

		//// **********************************************THIRD ATTEMPT
		attempt = "Third Attempt";

		// get new angle input
		launchAngle = getAngle(attempt);

		// recalculate values
		radian = convertRadians(launchAngle);
		flightTime = calcFlightTime(initialVelocity, radian, GRAVITATION);
		highestPoint = calcHighestPoint(flightTime, initialVelocity, radian, GRAVITATION);
		distanceTraveled = calcDistanceTraveled(flightTime, initialVelocity, radian);
		error = distanceToTarget - distanceTraveled;

		// check minError is smallest
		if (Math.abs(error) < Math.abs(minError)) {
			minError = error;
		}

		// check for a hit
		if (Math.abs(error) < 1) {
			JOptionPane.showMessageDialog(null, "\n\n\tA hit!\nYour shot landed within 1 foot of the target.");
			System.out.printf("\nYour best shot was within %.2f feet of the target.", minError);
			System.exit(0);
		}

		// output data
		trajectory = "Initial velocity: %.2f feet/second\n" + "Launch angle: %.2f degrees\n"
				+ "Flight time: %.2f seconds\n" + "Maximum height: %.2f feet\n" + "Distance traveled: %.2f feet\n"
				+ "Missed target by: %.2f feet";
		System.out.printf(trajectory, initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled,
				Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		// error analysis
		errorAnalysis(attempt, error, minError, launchAngle);

		//// **********************************************FOURTH ATTEMPT
		attempt = "Fourth Attempt";

		// get new angle input
		launchAngle = getAngle(attempt);

		// recalculate values
		radian = convertRadians(launchAngle);
		flightTime = calcFlightTime(initialVelocity, radian, GRAVITATION);
		highestPoint = calcHighestPoint(flightTime, initialVelocity, radian, GRAVITATION);
		distanceTraveled = calcDistanceTraveled(flightTime, initialVelocity, radian);
		error = distanceToTarget - distanceTraveled;

		// check minError is smallest
		if (Math.abs(error) < Math.abs(minError)) {
			minError = error;
		}

		// check for a hit
		if (Math.abs(error) < 1) {
			JOptionPane.showMessageDialog(null, "A hit!\nYour shot landed within 1 foot of the target.");
			System.out.printf("\nYour best shot was within %.2f feet of the target.", minError);
			System.exit(0);
		}

		// output data
		trajectory = "Initial velocity: %.2f feet/second\n" + "Launch angle: %.2f degrees\n"
				+ "Flight time: %.2f seconds\n" + "Maximum height: %.2f feet\n" + "Distance traveled: %.2f feet\n"
				+ "Missed target by: %.2f feet";
		System.out.printf(trajectory, initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled,
				Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		// error analysis
		errorAnalysis(attempt, error, minError, launchAngle);

		//// **********************************************FIFTH ATTEMPT
		attempt = "Fifth Attempt";

		// get new angle input
		launchAngle = getAngle(attempt);

		// recalculate values
		radian = convertRadians(launchAngle);
		flightTime = calcFlightTime(initialVelocity, radian, GRAVITATION);
		highestPoint = calcHighestPoint(flightTime, initialVelocity, radian, GRAVITATION);
		distanceTraveled = calcDistanceTraveled(flightTime, initialVelocity, radian);
		error = distanceToTarget - distanceTraveled;

		// check minError is smallest
		if (Math.abs(error) < Math.abs(minError)) {
			minError = error;
		}

		// check for a hit
		if (Math.abs(error) < 1) {
			JOptionPane.showMessageDialog(null, "A hit!\nYour shot landed within 1 foot of the target.");
			System.out.printf("\nYour best shot was within %.2f feet of the target.", minError);
			System.exit(0);
		}

		// output data
		trajectory = "Initial velocity: %.2f feet/second\n" + "Launch angle: %.2f degrees\n"
				+ "Flight time: %.2f seconds\n" + "Maximum height: %.2f feet\n" + "Distance traveled: %.2f feet\n"
				+ "Missed target by: %.2f feet";
		System.out.printf(trajectory, initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled,
				Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		// error analysis
		errorAnalysis(attempt, error, minError, launchAngle);

		// out of attempts
		System.out.printf(
				"\tEnd of fifth attempt. Please restart the program and try again.\n\tYour best shot was within %.2f feet of the target. Please restart the program and try again.",
				minError);

		System.exit(0);
	}// end of main

	// methods
	/**
	 * Gets launch angle input from the user
	 * 
	 * @param attempt String used to get message box title
	 * @return double type
	 */
	public static double getAngle(String attempt) {
		return Double.parseDouble(JOptionPane.showInputDialog(null, "Enter launch angle in degrees: ", attempt,
				JOptionPane.QUESTION_MESSAGE));
	}

	/**
	 * Takes angles in degrees and returns in radians
	 * 
	 * @param angle in degrees double type
	 * @return double type
	 */
	public static double convertRadians(double angle) {
		return angle * Math.PI / 180;
	}

	/**
	 * Returns double type, calculated flight time
	 * 
	 * @param velocity
	 * @param radian
	 * @param GRAVITATION
	 * @return
	 */
	public static double calcFlightTime(double velocity, double radian, final int GRAVITATION) {
		return 2 * velocity * Math.sin(radian) / GRAVITATION;
	}

	/**
	 * Returns double type, maximum height
	 * 
	 * @param flightTime
	 * @param velocity
	 * @param radian
	 * @param GRAVITATION
	 * @return
	 */
	public static double calcHighestPoint(double flightTime, double velocity, double radian, final int GRAVITATION) {
		double T = flightTime / 2;
		return ((T * velocity * Math.sin(radian)) - (Math.pow(T, 2) * GRAVITATION / 2));
	}

	/**
	 * Returns double type, distance traveled
	 * 
	 * @param flightTime
	 * @param velocity
	 * @param radian
	 * @return
	 */
	public static double calcDistanceTraveled(double flightTime, double velocity, double radian) {
		return flightTime * velocity * Math.cos(radian);
	}

	/**
	 * Creates information box displaying parameters. Also prints the same info to
	 * console.
	 * 
	 * @param initialVelocity
	 * @param launchAngle
	 * @param flightTime
	 * @param highestPoint
	 * @param distanceTraveled
	 * @param error
	 */
	public static void trajectoryDataReport(double initialVelocity, double launchAngle, double flightTime,
			double highestPoint, double distanceTraveled, double error) {
		String title = "Trajectory Data Report";
		String range = String.format(
				"Initial velocity: %.2f feet/second\n" + "Launch angle: %.2f degrees\n" + "Flight time: %.2f seconds\n"
						+ "Maximum height: %.2f feet\n" + "Distance traveled: %.2f feet\n"
						+ "Missed target by: %.2f feet",
				initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, Math.abs(error));
		JOptionPane.showMessageDialog(null, range, title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Prints feedback to console on whether the shot was too far or too short.
	 * 
	 * @param attempt
	 * @param error
	 * @param minError
	 * @param launchAngle
	 */
	public static void errorAnalysis(String attempt, double error, double minError, double launchAngle) {
		if (attempt == "") {
			attempt = "First Attempt";
		}
		String tooFar = "\n\n\t" + attempt + ": You overshot the target. Decrease your launch angle from " + launchAngle
				+ " degrees.";
		String tooShort = "\n\n\t" + attempt + ": You fell short of the target. Increase your launch angle from "
				+ launchAngle + " degrees.";
		if (error < 0) {
			System.out.println(tooFar);
		} else {
			System.out.println(tooShort);
		}

	}
}// end of MissileInMotion
