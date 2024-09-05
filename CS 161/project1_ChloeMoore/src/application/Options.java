package application;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Options extends GridPane{
    // create title label and checkboxes
    Label title = new Label("Loan Term");
    CheckBox auto_trans = new CheckBox("Auto Transmission: $1800");
    CheckBox antilock_brakes = new CheckBox("AntiLock Brake: $1200");
    CheckBox sun_roof = new CheckBox("Sun Roof: $800");
    CheckBox nav_sys = new CheckBox("Navigation System: $1350");
    CheckBox audio_pack = new CheckBox("Audio Package: $1550");

    // constrictor for this class
    public Options() {
        // set title font weight to bold
        title.getStyleClass().add("label-bold");

        // placing objects inside this class (a gridpane)
        add(title, 0, 0);
        add(auto_trans, 0, 1);
        add(antilock_brakes, 0, 2);
        add(sun_roof, 0, 3);
        add(nav_sys, 0, 4);
        add(audio_pack, 0, 5);

        // set antilock brake option to be selected by default
        antilock_brakes.setSelected(true);

        // set the display settings
        setPadding(new Insets(5));
        setVgap(5);
    }

    // METHODS
    public void reset() {
        // sets all checkboxes to be unchecked, except for antilock brakes
        auto_trans.setSelected(false);
        antilock_brakes.setSelected(true);
        sun_roof.setSelected(false);
        nav_sys.setSelected(false);
        audio_pack.setSelected(false);
    }

    public double get_options_total() {
        // calculates total cost of selected options, and returns that value
        double total = 0;
        if (auto_trans.isSelected()) {
            total += 1800;
        }
        if (antilock_brakes.isSelected()) {
            total += 1200;
        }
        if (sun_roof.isSelected()) {
            total += 800;
        }
        if (nav_sys.isSelected()) {
            total += 1350;
        }
        if (audio_pack.isSelected()) {
            total += 1550;
        }
        return total;
    }
}
