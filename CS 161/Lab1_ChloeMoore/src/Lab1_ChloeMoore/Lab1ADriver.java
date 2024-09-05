package Lab1_ChloeMoore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1ADriver {

	public static void main(String[] args) throws FileNotFoundException {
		// objects
		File file = new File("rectangles.txt");
		Scanner rect_reader = new Scanner(file);
		
		// get array length and set new array
		int array_length = rect_reader.nextInt();
		rect_reader.nextLine();
		Rectangle[] rect_array = new Rectangle[array_length];
		
		// reading the file and adding rectangles to the array
		int count = 0;
		while (rect_reader.hasNextLine()) {
			String line = rect_reader.nextLine();
			String[] params = line.split(" ");
						
			int row = Integer.parseInt(params[0].strip());
			int col = Integer.parseInt(params[1].strip());
			boolean fill = false;
			
			if (params[2].strip().equals("filled")) {
				fill = true;
			} else if (params[2].strip().equals("unfilled")) {
				fill = false;
			}

			Rectangle rect = new Rectangle(row, col, fill);
			rect_array[count] = rect;
			count += 1;
			}		
		
		// printing rectangles from array
		for (Rectangle rect : rect_array) {
			String box = rect.to_string();
			System.out.println(box);
		}

		// close scanner		
		rect_reader.close();
	}

}
