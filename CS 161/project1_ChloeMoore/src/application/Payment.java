package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class Payment extends GridPane {
	// create labels for payment section
	Label title = new Label("Payment Information");
	Label loan_lab = new Label("Total Loan Amount: $");
	Label monthly_lab = new Label("Monthly Payment: $");
	Label total_lab = new Label("Total Payment: $");
	Label loan_num_lab = new Label("0.0");
	Label monthly_num_lab = new Label("0.0");
	Label total_num_lab = new Label("0.0");

	// constructor to create this section
	public Payment() {
		// set title font weight to bold
		title.getStyleClass().add("label-bold");

		// placing labels inside this class (a gridpane)
		add(title, 0, 0);
		add(loan_lab, 0, 1);
		add(monthly_lab, 0, 2);
		add(total_lab, 0, 3);
		add(loan_num_lab, 1, 1);
		add(monthly_num_lab, 1, 2);
		add(total_num_lab, 1, 3);

		// set the display settings
		setPadding(new Insets(5));
		setVgap(5);
	}

	// METHODS
	public void reset() {
		// resets the value for all number fields to 0.0
		total_num_lab.setText("0.0");
		loan_num_lab.setText("0.0");
		monthly_num_lab.setText("0.0");
	}

	public void set_total(double total) {
		String total_str = String.format("%.2f", total);
		total_num_lab.setText(total_str);
	}

	public void set_monthly_payment(double monthly) {
		String monthly_str = String.format("%.2f", monthly);
		monthly_num_lab.setText(monthly_str);
	}

	public void set_loan_amt(double loan) {
		String loan_str = String.format("%.2f", loan);
		loan_num_lab.setText(loan_str);
	}
}
