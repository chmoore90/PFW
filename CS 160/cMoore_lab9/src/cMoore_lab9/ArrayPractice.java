/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 9
 */

package cMoore_lab9;

import java.util.Random;

public class ArrayPractice {
	// variables
	private int[] numbers;
	private Rectangle[] boxes;
	private String[] names_list;
	private final int base_length = 10;
	private Random rand = new Random();

	// constructors
	public ArrayPractice() {
		this.numbers = new int[base_length];
		this.boxes = new Rectangle[base_length];
		this.names_list = new String[base_length];
		
		load_numbers();
		load_boxes();
	}

	public ArrayPractice(int num_length, int box_length, String[] string) {
		numbers = new int[num_length];
		boxes = new Rectangle[box_length];
		names_list = string;
		
		load_numbers();
		load_boxes();
	}

	// methods
	public void load_numbers() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(-100, 101);
		}
	}

	public void load_boxes() {
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Rectangle(rand.nextDouble(), rand.nextDouble());
		}
	}
	
	public void display_numbers() {
		for (int i =0; i < numbers.length; i ++) {
			System.out.println(numbers[i]);
		}
	}
	
	public void display_boxes() {
		for (int i =0; i < boxes.length; i ++) {
			System.out.println(boxes[i].toString());
		}
	}
	
	public void display_list() {		
		for (int i =0; i < names_list.length; i ++) {
			System.out.println(names_list[i]);
		}
	}

}
