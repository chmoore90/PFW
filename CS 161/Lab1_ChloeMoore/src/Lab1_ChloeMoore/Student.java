package Lab1_ChloeMoore;

import java.io.PrintWriter;

public class Student {
	// variables
	private String name;
	private char grade;
	private double average;
	private int[] scores;
	
	// constructors
	public Student() {
		name = "No Name";
	}
	public Student(String name, int[] scores) {
		this.name = name;
		this.scores = scores;
	}
	
	// getters
	public String get_name() {
		return name;
	}
	public char get_grade() {
		return grade;
	}
	public double get_avg() {
		return average;
	}
	public int[] get_scores() {
		return scores;
	}
	
	// setters
	public void set_name(String name) {
		this.name = name;
	}
	public void set_grade(char grade) {
		this.grade = grade;
	}
	public void set_avg(double avg) {
		average = avg;
	}
	public void set_scores(int[] scores) {
		this.scores = scores;
	}
	
	// other methods
	public void calculate_avg() {
		double sum = 0;
		int count = 0;
		for (int score : scores) {
			sum += score;
			count += 1;
		}
		
		double avg = sum/count;
		set_avg(avg);
	}
	
	public void calculate_grade() {
		double avg = get_avg();
		if (avg >= 90) {
			set_grade('A');
		} else if (avg >= 80) {
			set_grade('B');
		} else if (avg >=70) {
			set_grade('C');
		} else if (avg >= 60) {
			set_grade('D');
		} else {
			set_grade('F');
		}
	}
	
	public void generate_output(PrintWriter out_file) {
		out_file.printf("%s\t%d\t%d\t%d\t%d\t%d\t%f\t%c\n",
				name, scores[0], scores[1], scores[2], scores[3], scores[4], average, grade);
	}
}
