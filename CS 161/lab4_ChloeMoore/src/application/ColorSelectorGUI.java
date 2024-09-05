package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ColorSelectorGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// create atomic elements of the GUI
		Label north_lab = new Label("North");
		Label south_lab = new Label("South");
		Label west_lab = new Label("West");
		Label east_lab = new Label("East");
		Label location_lab = new Label("Locations");
		Label colors_lab = new Label("Background Colors");
		CheckBox north_check = new CheckBox("North");
		CheckBox south_check = new CheckBox("South");
		CheckBox west_check = new CheckBox("West");
		CheckBox east_check = new CheckBox("East");
		RadioButton salmon = new RadioButton("Salmon");
		RadioButton green = new RadioButton("Spring Green");
		RadioButton orange = new RadioButton("Orange");
		RadioButton cyan = new RadioButton("Cyan");

		// give bold font to location and color labels, set the prefWidth
		location_lab.setStyle("-fx-font-weight: bold");
		location_lab.setPrefWidth(80);
		colors_lab.setStyle("-fx-font-weight: bold");
		colors_lab.setPrefWidth(140);

		// set text color of radiobuttons to match the associated color
		salmon.setStyle("-fx-text-fill: salmon");
		green.setStyle("-fx-text-fill: springgreen");
		orange.setStyle("-fx-text-fill: orange");
		cyan.setStyle("-fx-text-fill: cyan");

		// group radio buttons together
		ToggleGroup toggle = new ToggleGroup();
		salmon.setToggleGroup(toggle);
		green.setToggleGroup(toggle);
		orange.setToggleGroup(toggle);
		cyan.setToggleGroup(toggle);

		// set defaults: all checkboxes and color cyan selected
		north_check.setSelected(true);
		south_check.setSelected(true);
		west_check.setSelected(true);
		east_check.setSelected(true);
		cyan.setSelected(true);

		// create grid for center node, place check and radio buttons inside
		GridPane grid = new GridPane();
		grid.setPrefSize(250, 160);
		grid.setHgap(15);
		grid.setVgap(4);
		grid.setPadding(new Insets(10));
		grid.add(location_lab, 0, 0);
		grid.add(north_check, 0, 1);
		grid.add(south_check, 0, 2);
		grid.add(west_check, 0, 3);
		grid.add(east_check, 0, 4);
		grid.add(colors_lab, 1, 0);
		grid.add(salmon, 1, 1);
		grid.add(green, 1, 2);
		grid.add(orange, 1, 3);
		grid.add(cyan, 1, 4);

		// create borderpane object for placing direction labels and center block
		BorderPane border = new BorderPane();
		border.setTop(north_lab);
		border.setBottom(south_lab);
		border.setLeft(west_lab);
		border.setRight(east_lab);
		border.setCenter(grid);

		// create scene for border and display stage
		Scene scene = new Scene(border);
		stage.setTitle("Color Selector GUI");
		stage.setScene(scene);
		stage.show();

		// setting up alignments for labels
		north_lab.setAlignment(Pos.CENTER);
		north_lab.setPrefSize(stage.getWidth(), 40);
		south_lab.setAlignment(Pos.CENTER);
		south_lab.setPrefSize(stage.getWidth(), 40);
		west_lab.setAlignment(Pos.CENTER);
		west_lab.setPrefSize(40, stage.getHeight()-80);
		east_lab.setAlignment(Pos.CENTER);
		east_lab.setPrefSize(40, stage.getHeight()-80);

		// set up SALMON radio button event handler/actions
		salmon.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (north_check.isSelected()) {
					north_lab.setStyle("-fx-background-color: salmon");
				}
				if (south_check.isSelected()) {
					south_lab.setStyle("-fx-background-color: salmon");
				}
				if (west_check.isSelected()) {
					west_lab.setStyle("-fx-background-color: salmon");
				}
				if (east_check.isSelected()) {
					east_lab.setStyle("-fx-background-color: salmon");
				}
			}
		});

		// set up GREEN radio button event handler/actions
		green.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (north_check.isSelected()) {
					north_lab.setStyle("-fx-background-color: springgreen");
				}
				if (south_check.isSelected()) {
					south_lab.setStyle("-fx-background-color: springgreen");
				}
				if (west_check.isSelected()) {
					west_lab.setStyle("-fx-background-color: springgreen");
				}
				if (east_check.isSelected()) {
					east_lab.setStyle("-fx-background-color: springgreen");
				}
			}
		});

		// set up ORANGE radio button event handler/actions
		orange.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (north_check.isSelected()) {
					north_lab.setStyle("-fx-background-color: orange");
				}
				if (south_check.isSelected()) {
					south_lab.setStyle("-fx-background-color: orange");
				}
				if (west_check.isSelected()) {
					west_lab.setStyle("-fx-background-color: orange");
				}
				if (east_check.isSelected()) {
					east_lab.setStyle("-fx-background-color: orange");
				}
			}
		});

		// set up CYAN radio button event handler/actions
		cyan.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) { // if the radiobutton is checked, corresponding label changes color
				if (north_check.isSelected()) {
					north_lab.setStyle("-fx-background-color: cyan");
				}
				if (south_check.isSelected()) {
					south_lab.setStyle("-fx-background-color: cyan");
				}
				if (west_check.isSelected()) {
					west_lab.setStyle("-fx-background-color: cyan");
				}
				if (east_check.isSelected()) {
					east_lab.setStyle("-fx-background-color: cyan");
				}
			}
		});

		// Fires cyan radio button event on launch to make border cyan by default
		cyan.fireEvent(new ActionEvent());

	} // end stage

}
