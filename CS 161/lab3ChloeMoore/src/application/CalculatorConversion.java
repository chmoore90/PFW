package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CalculatorConversion extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primary_stage) throws Exception {
		// create atomic GUI elements
		Label centi_label = new Label("Centimeters:");
		Label meters_label = new Label("Meters:");
		Label inches_label = new Label("Inches:");
		Label yards_label = new Label("Yards:");
		TextField centi_text = new TextField("0.0");
		TextField meters_text = new TextField("0.0");
		TextField inches_text = new TextField("0.0");
		TextField yards_text = new TextField("0.0");
		Button clear_button = new Button();
		Button calc_button = new Button();
		Button exit_button = new Button();
		
		// set width for buttons
		clear_button.setPrefWidth(75);
		calc_button.setPrefWidth(75);
		exit_button.setPrefWidth(75);


		// set default values for GUI title and buttons
		primary_stage.setTitle("Conversion Calculator");
		clear_button.setText("Clear");
		calc_button.setText("Calculate");
		exit_button.setText("Exit");
		
		// create and populate hbox/vbox
		HBox centi_hbox = new HBox(centi_label, centi_text);
		HBox meters_hbox = new HBox(meters_label, meters_text);
		HBox inches_hbox = new HBox(inches_label, inches_text);
		HBox yards_hbox = new HBox(yards_label, yards_text);
		VBox buttons_vbox = new VBox(clear_button, calc_button, exit_button);
		VBox cm_m_meters_vbox = new VBox (10, centi_hbox, meters_hbox);
		VBox in_yards_vbox = new VBox (10, inches_hbox, yards_hbox);
		
		// set padding for hboxes
		Insets set_5 = new Insets(5);
		centi_hbox.setPadding(set_5);
		meters_hbox.setPadding(set_5);
		inches_hbox.setPadding(set_5);
		yards_hbox.setPadding(set_5);
		
		
		// create and populate gridpane with hbox/vbox
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.add(cm_m_meters_vbox, 0, 0);
		grid.add(in_yards_vbox, 1, 0);
		grid.add(buttons_vbox, 2, 0);
		
		// create scene for gridpane and display stage
		Scene scene = new Scene(grid);
		primary_stage.setScene(scene);
		primary_stage.show();
		
		// set up calc_button event handler/actions
		calc_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String centi = centi_text.getText();
				String meters = meters_text.getText();
				String inches = inches_text.getText();
				String yards = yards_text.getText();
				
				String[] units = {centi, meters, inches, yards};
				String base = "";
				
				for (int i=0 ; i < units.length ; i++) { // iterate through textfield values to find the non-zero value to convert
					if (!units[i].equals("0.0")) {
						base = units[i];
						if (i == 0) {					// run conversion method, depending on index
							convert_cm(base, meters_text, inches_text, yards_text);
							break;
						} else if (i == 1){
							convert_m(base, centi_text, inches_text, yards_text);
							break;
						} else if (i == 2) {
							convert_in(base, centi_text, meters_text, yards_text);
							break;
						} else {
							convert_yd(base, centi_text, meters_text, inches_text);	
							break;
							}
					}
				}
			} 
		});	
		
		// set up clear_button event handler/actions
		clear_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) { // reset all textfield values to 0
				centi_text.setText("0.0");
				meters_text.setText("0.0");
				inches_text.setText("0.0");
				yards_text.setText("0.0");

			}
		});
		
		// set up exit_button event handler/actions
		exit_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) { // closes GUI window
				System.exit(0);
			}
		});
	}
	
	// unit conversion methods
	
	// CENTIMETERS
	public void convert_cm(String centi, TextField m_text, TextField in_text, TextField yd_text) {
		// convert input from string to double, calculates conversion based on that
		double cm = Double.parseDouble(centi);
		double m = cm * 0.01;
		double in = cm * 0.3937;
		double yd = in * 0.0278;
		
		// sets conversion values to textfields, values are rounded to two decimal places
		m_text.setText(String.format("%.2f", m));
		in_text.setText(String.format("%.2f", in));
		yd_text.setText(String.format("%.2f", yd));	
		}
	
	// METERS
	public void convert_m(String meter, TextField cm_text, TextField in_text, TextField yd_text) {
		// convert input from string to double, calculates conversion based on that
		double m = Double.parseDouble(meter);
		double cm = m * 100;
		double in = cm * 0.3937;
		double yd = in * 0.0278;
		
		// sets conversion values to textfields, values are rounded to two decimal places
		cm_text.setText(String.format("%.2f", cm));
		in_text.setText(String.format("%.2f", in));
		yd_text.setText(String.format("%.2f", yd));	
		}
	
	// INCHES
	public void convert_in(String inch, TextField cm_text, TextField m_text, TextField yd_text) {
		// convert input from string to double, calculates conversion based on that
		double in = Double.parseDouble(inch);
		double cm = in * 2.54;
		double m = cm * 0.01;
		double yd = in * 0.0278;
		
		// sets conversion values to textfields, values are rounded to two decimal places
		cm_text.setText(String.format("%.2f", cm));
		m_text.setText(String.format("%.2f", m));
		yd_text.setText(String.format("%.2f", yd));	
		}
	
	// YARDS
	public void convert_yd(String yard, TextField cm_text, TextField m_text, TextField in_text) {
		// convert input from string to double, calculates conversion based on that
		double yd = Double.parseDouble(yard);
		double in = yd * 36;
		double cm = in * 2.54;
		double m = cm * 0.01;
		
		// sets conversion values to textfields, values are rounded to two decimal places
		cm_text.setText(String.format("%.2f", cm));
		m_text.setText(String.format("%.2f", m));
		in_text.setText(String.format("%.2f", in));	
		}
}
