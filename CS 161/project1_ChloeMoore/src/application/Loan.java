package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class Loan extends GridPane {
    // create title label and radiobuttons for loan section
    Label title = new Label("Loan Term");
    RadioButton mo_24 = new RadioButton("24 Months");
    RadioButton mo_36 = new RadioButton("36 Months");
    RadioButton mo_48 = new RadioButton("48 Months");
    RadioButton mo_60 = new RadioButton("60 Months");

    // set default value for annual interest rate to 7%
    double air = 0.07;

    // constructor to set up this section
    public Loan() {
	// set title font weight to bold
    title.getStyleClass().add("label-bold");

    // grouping the radio buttons together
    ToggleGroup toggle = new ToggleGroup();
    mo_24.setToggleGroup(toggle);
    mo_36.setToggleGroup(toggle);
    mo_48.setToggleGroup(toggle);
    mo_60.setToggleGroup(toggle);

    // placing objects inside this class (a gridpane)
    add(title, 0, 0);
    add(mo_24, 0, 1);
    add(mo_36, 0, 2);
    add(mo_48, 0, 3);
    add(mo_60, 0, 4);

    // set 24 months radiobutton to be selected by default
    mo_24.setSelected(true);

    // set the display settings
    setPadding(new Insets(5));
    setVgap(5);

    // EVENT HANDLING
    mo_24.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            air = 0.07;
        }
    });

    mo_36.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            air = 0.06;
        }
    });

    mo_48.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            air = 0.055;
        }
    });

    mo_60.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            air = 0.05;
        }
    });

    }

    // METHODS
    public double get_air() {
        // getter for annual interest rate
        return air;
    }

    public double get_months() {
        // getting for length of loan in months
        double months = 0;
        if (mo_24.isSelected()) {
            months = 24;
        } else if (mo_36.isSelected()) {
            months = 36;
        } else if (mo_48.isSelected()) {
            months = 48;
        } else if (mo_60.isSelected()) {
            months = 60;
        }
        return months;
    }

    public void reset() {
        mo_24.setSelected(true);
    }
}
