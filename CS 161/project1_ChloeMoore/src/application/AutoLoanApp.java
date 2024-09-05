package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AutoLoanApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// create buttons "native" to this application layer
		Button calc = new Button("Calculate");
		Button reset = new Button("Reset");
		Button exit = new Button("Exit");

		// create instance of each section class
		Payment payment = new Payment();
		Loan loan = new Loan();
		Finance finance = new Finance();
		Options options = new Options();

		// adds black border to each section
		payment.getStyleClass().add("grid-container");
		loan.getStyleClass().add("grid-container");
		finance.getStyleClass().add("grid-container");
		options.getStyleClass().add("grid-container");

		// create gridpane for holding the class instances and buttons
		GridPane main_grid = new GridPane();

		// adding classes and buttons to gridpane
		main_grid.add(payment, 0, 0);
		main_grid.add(loan, 1, 0);
		main_grid.add(finance, 0, 1);
		main_grid.add(options, 1, 1);

		HBox button_box = new HBox(calc, reset, exit);
		main_grid.add(button_box, 0, 2, 2, 1);
		button_box.setPadding(new Insets(5));
		button_box.setSpacing(20);
		button_box.setAlignment(Pos.CENTER);
		button_box.getStyleClass().add("grid-container");

		// create scene for the main grid and display the stage
		Scene scene = new Scene(main_grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // makes all buttons have bold text
		stage.setTitle("Auto Loan Calculator");
		stage.setScene(scene);
		stage.show();

		// EVENT HANDLING
		exit.setOnAction(new EventHandler<ActionEvent>() {
			// exits application
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		reset.setOnAction(new EventHandler<ActionEvent>() {
			// resets all sections to their default settings
			@Override
			public void handle(ActionEvent event) {
				payment.reset();
				loan.reset();
				finance.reset();
				options.reset();
			}
		});

		calc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double base_price = finance.get_base_price();
				double down_payment = finance.get_downpayment();
				double tax_rate = finance.get_tax_rate();
				double options_total = options.get_options_total();

				double sales_tax = tax_rate*(base_price - down_payment + options_total);
				double loan_amt = base_price - down_payment + options_total + sales_tax;

				double monthly_interest = loan.get_air()/12;
				double months = loan.get_months();
				double monthly_payment = loan_amt*(monthly_interest*Math.pow(1 + monthly_interest, months)) / (Math.pow(1+ monthly_interest, months) - 1);

				double total_payment = monthly_payment * months + down_payment;

				payment.set_loan_amt(loan_amt);
				payment.set_monthly_payment(monthly_payment);
				payment.set_total(total_payment);
			}
		});

	}


}
