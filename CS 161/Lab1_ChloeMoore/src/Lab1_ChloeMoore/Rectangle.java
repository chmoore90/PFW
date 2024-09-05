package Lab1_ChloeMoore;

public class Rectangle {
	private int num_rows;
	private int num_cols;
	private boolean filled;
	
	// constructors
	public Rectangle() {
		num_rows = 1;
		num_cols = 1;
		filled = false;
	}
	
	public Rectangle(int rows, int cols, boolean fill) {
		num_rows = rows;
		num_cols = cols;
		filled = fill;
	}
	
	// getters
	public int get_rows() {
		return num_rows;
	}
	
	public int get_cols() {
		return num_cols;
	}
	
	public boolean get_fill() {
		return filled;
	}
	
	//setters
	public void set_rows(int r) {
		num_rows = r;
	}
	
	public void set_cols(int c) {
		num_cols = c;
	}
	
	public void set_fill(boolean f) {
		filled = f;
	}
	
	// other methods
	public String to_string() {
		String output = "";
		
		// top row
		for (int i = 0; i < num_cols; i++) {
			output = output + "#";
		}
		
		// actions for 1 or 2 row boxes
		if (num_rows == 1) {
			return output;
		} else if (num_rows == 2) {
			output = output + "\n";
			for (int i = 0; i < num_cols; i++) {
				output = output + "#";
			}
			return output;
		}
		
		output = output + "\n";
		
		// body rows
		for (int i = 0; i < num_rows - 2; i++) {
			output = output + "#";
			String x;
			
			if (filled == true) {
				x = "#";
			} else {
				x = " ";
			}
			
			for (int j=0; j < num_cols-2; j++) {
				output = output + x;
			}
			output = output + "#\n";
		}
		
		// end row
		for (int m = 0; m < num_cols; m++) {
			output = output + "#";
		}
		output = output + "\n";
		
		return output;
	}
}
