package Lab1_ChloeMoore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LabBDriver {

	public static void main(String[] args) throws FileNotFoundException {
		// objects
		Student[] students = new Student[30];
		File students_in = new File("students.in.txt");
		Scanner reader = new Scanner(students_in);
		PrintWriter writer = new PrintWriter("students.out.txt");
		
		// reading data from student.in file
		int count = 0; // counter to track index of student array when adding students
		while (reader.hasNextLine()) {
			// read file
			String line = reader.nextLine();
			String[] info = line.split(" ");
			
			// parse info, assign info to variables
			int[] scores = new int[5];
			String name = info[0].strip();
			int test0 = Integer.parseInt(info[1].strip());
			scores[0] = test0;
			int test1 = Integer.parseInt(info[2].strip());
			scores[1] = test1;
			int test2 = Integer.parseInt(info[3].strip());
			scores[2] = test2;
			int test3 = Integer.parseInt(info[4].strip());
			scores[3] = test3;
			int test4 = Integer.parseInt(info[5].strip());
			scores[4] = test4;

			// create student object and get avg, grade
			Student student = new Student(name, scores);
			student.calculate_avg();
			student.calculate_grade();
			
			// add student to array and update index tracker
			students[count] = student;
			count += 1;
		}
		
		// begin writing new file (headers)
		writer.println("Student\t\tTest1\tTest2\tTest3\tTest4\tTest5\tAvg\tGrade\t\n");
		
		// variables for calculating class average
		double class_sum = 0;
		int class_count = 0;
		
		// write student data to the file
		for (Student student : students) {
			if (student != null) {
				String name = student.get_name();
				int test1 = student.get_scores()[0];
				int test2 = student.get_scores()[1];
				int test3 = student.get_scores()[2];
				int test4 = student.get_scores()[3];
				int test5 = student.get_scores()[4];
				double avg = student.get_avg();
				char grade = student.get_grade();
				
				// add student average to class sum, update class counter
				class_sum += avg;
				class_count += 1;
				
				// write student info to file
				writer.print(String.format("%s\t\t%d\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
					name, test1, test2, test3, test4, test5, avg, grade));
			}
		}
		
		// write class average to file
		double class_avg = class_sum/class_count;
		writer.printf("\nClass Average = %.2f", class_avg);
		
		// close scanner and printwriter
		reader.close();
		writer.flush();
		writer.close();
	}

}
