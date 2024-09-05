/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 9
 */

package cMoore_lab9;

public class Rectangle {
	private double length;
	private double width;

	// getters
	public double get_length() {
		return length;
	}

	public double get_width() {
		return width;
	}

	// setters
	public void set_length(double d) {
		if (d >= 0) {
			length = d;
		} else {
			length = 0;
		}
	}

	public void set_width(double d) {
		if (d >= 0) {
			width = d;
		} else {
			width = 0;
		}
	}

	// other methods
	public double computeArea() {
		return length * width;
	}

	public double computePerimeter() {
		return (2 * length) + (2 * width);
	}

	public String toString() {
		return String.format("Length: %,.2f\nWidth: %,.2f", length, width);
	}

	public void displayRectangle() {
		System.out.println(toString());
	}

	public boolean equals(Rectangle rect) {
		if (length == rect.length && width == rect.width) {
			return true;
		} else {
			return false;
		}
	}

	// constructors
	public Rectangle(double len, double wit) {
		length = len;
		width = wit;
	}

	public Rectangle() {
	}

	public Rectangle(Rectangle rect) {
		this.length = rect.length;
		this.width = rect.width;
	}
	
} // end of Rectangle class

