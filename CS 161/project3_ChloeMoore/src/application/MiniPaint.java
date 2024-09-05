package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class MiniPaint extends Application {
	ShapeCollection collection = new ShapeCollection();
	double x_origin = 0; // these origin doubles will be used to resize the rectangles
	double y_origin = 0;

	// controls
	Label tool_title = new Label("Tool");
	Label color_title = new Label("Color");
	Label red_lbl = new Label("Red");
	Label green_lbl = new Label("Green");
	Label blue_lbl = new Label("Blue");
	Label current_color = new Label("Current:  ");
	Ellipse color_ellipse = new Ellipse(25, 16);
	RadioButton draw_radio = new RadioButton("Draw");
	RadioButton move_radio = new RadioButton("Move");
	RadioButton delete_radio = new RadioButton("Delete");
	ComboBox<String> shapes_dropdown = new ComboBox<>();
	Slider red_slider = new Slider(0, 1, 0);
	Slider green_slider = new Slider(0, 1, 0);
	Slider blue_slider = new Slider(0, 1, 0);
	Button clear_button = new Button("Clear Drawing Area");
	Label width_lbl = new Label("Line width:  ");
	TextField width_field = new TextField("5");

	// hboxs
	HBox curr_col_hbox = new HBox(current_color, color_ellipse);
	HBox width_box = new HBox(width_lbl, width_field);

	// vbox for right-side (tools/color menu)
	VBox clear_btn_box = new VBox(clear_button);
	VBox menu_vbox = new VBox(tool_title, draw_radio, move_radio, delete_radio, shapes_dropdown, width_box, color_title,
				red_lbl, red_slider, green_lbl, green_slider, blue_lbl, blue_slider, curr_col_hbox, clear_btn_box);

	// pane for left-side (drawing area)
	Pane draw_pane = new Pane();

	// master window (as a gridpane)
	GridPane master_grid = new GridPane();

	// Initiating event handlers
	EventHandler<MouseEvent> shape_starter = new StartShape();
	EventHandler<MouseEvent> shape_finisher = new UpdateShape();
	EventHandler<MouseEvent> shape_mover = new MoveShape();
	EventHandler<MouseEvent> shape_deleter = new DeleteShape();

	@Override
	public void start(Stage stage) throws Exception {
		// SETTING UP CONTROLS/CONTAINERS/MASTER GRID
		tool_title.getStyleClass().add("label-title");
		color_title.getStyleClass().add("label-title");
		ToggleGroup toggle = new ToggleGroup();
		draw_radio.setToggleGroup(toggle);
		move_radio.setToggleGroup(toggle);
		delete_radio.setToggleGroup(toggle);
		draw_radio.setSelected(true);
		shapes_dropdown.getItems().addAll("Line", "Rectangle", "Ellipse");
		shapes_dropdown.getSelectionModel().selectFirst();
		shapes_dropdown.setPrefWidth(105);
		width_field.setPrefWidth(40);
		red_slider.getStyleClass().add("slider-red");
		green_slider.getStyleClass().add("slider-green");
		blue_slider.getStyleClass().add("slider-blue");
		color_ellipse.setStroke(Color.BLACK);
		color_ellipse.setStrokeWidth(0.25);
		clear_btn_box.setPadding(new Insets(10));
		menu_vbox.setSpacing(4);
		menu_vbox.setPadding(new Insets(15));
		draw_pane.setPrefSize(500, 500);
		master_grid.setGridLinesVisible(true);
		master_grid.add(menu_vbox, 0, 0);
		master_grid.add(draw_pane, 1, 0);

		// Assigning SET ON events
		draw_radio.setOnAction(new ActivateDrawer());
		move_radio.setOnAction(new ActivateMover());
		delete_radio.setOnAction(new ActivateDeleter());
		shapes_dropdown.setOnAction(new ToggleLineOptions());
		red_slider.valueProperty().addListener(new UpdateColorEllipse());
		green_slider.valueProperty().addListener(new UpdateColorEllipse());
		blue_slider.valueProperty().addListener(new UpdateColorEllipse());
		clear_button.setOnAction(new ClearDrawArea());

		// trigger draw radio button event to start
		draw_radio.fireEvent(new ActionEvent());

		// Finalizing scene/stage for display
		Scene scene = new Scene(master_grid);
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		stage.setTitle("Definitely Not Paint");
		stage.setScene(scene);
		stage.show();

	}

	// METHODS
	public Color get_color(Slider r, Slider g, Slider b) {
		double red = r.getValue();
		double green = g.getValue();
		double blue = b.getValue();
		return new Color(red, green, blue, 1);
	}

	public void toggle_line_options() {
		if (!shapes_dropdown.getValue().equals("Line")) {
			width_field.setDisable(true);
			width_lbl.getStyleClass().set(0, "label-disabled");
		} else {
			width_field.setDisable(false);
			width_lbl.getStyleClass().set(0, "label-enabled");
		}
	}

	public void manage_eventhandlers () {
		if (draw_radio.isSelected()) {
			// adds events for drawing/enables line width options
			draw_pane.addEventHandler(MouseEvent.MOUSE_PRESSED, shape_starter);
			draw_pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, shape_finisher);
			shapes_dropdown.setDisable(false);
			width_lbl.getStyleClass().set(0, "label-enabled");
			width_field.setDisable(false);
			// removes all other event handlers
			for (Shape shape : collection.get_all_shapes()) {
				shape.removeEventHandler(MouseEvent.MOUSE_DRAGGED, shape_mover);
				shape.removeEventHandler(MouseEvent.MOUSE_CLICKED, shape_deleter);
			}

		} else if (move_radio.isSelected()) {
			// adds events for moving
			for (Shape shape : collection.get_all_shapes()) {
				shape.addEventHandler(MouseEvent.MOUSE_DRAGGED, shape_mover);
			}
			// removes all other event handlers/disables line width options
			draw_pane.removeEventHandler(MouseEvent.MOUSE_PRESSED, shape_starter);
			draw_pane.removeEventHandler(MouseEvent.MOUSE_DRAGGED, shape_finisher);
			for (Shape shape : collection.get_all_shapes()) {
				shape.removeEventHandler(MouseEvent.MOUSE_CLICKED, shape_deleter);
			}
			shapes_dropdown.setDisable(true);
			width_lbl.getStyleClass().set(0, "label-disabled");
			width_field.setDisable(true);

		} else {
			// adds events for deleting
			for (Shape shape : collection.get_all_shapes()) {
				shape.addEventHandler(MouseEvent.MOUSE_CLICKED, shape_deleter);
			}
			// removes all other event handlers/disables line width textfield
			draw_pane.removeEventHandler(MouseEvent.MOUSE_PRESSED, shape_starter);
			draw_pane.removeEventHandler(MouseEvent.MOUSE_DRAGGED, shape_finisher);
			for (Shape shape : collection.get_all_shapes()) {
				shape.removeEventHandler(MouseEvent.MOUSE_DRAGGED, shape_mover);
			}
			shapes_dropdown.setDisable(true);
			width_lbl.getStyleClass().set(0, "label-disabled");
			width_field.setDisable(true);
		}
	}

	// EVENT HANDLER CLASSES
	class ToggleLineOptions implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			toggle_line_options();
		}
	}

	class ClearDrawArea implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			collection.get_lines().clear();
			collection.get_rects().clear();
			collection.get_ellipses().clear();
			draw_pane.getChildren().clear();
		}
	}

	class UpdateColorEllipse implements ChangeListener<Number> {
		@Override
		public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			color_ellipse.setFill(get_color(red_slider, green_slider, blue_slider));
		}
	}

	class StartShape implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			String shape = shapes_dropdown.getValue();

			// creates new line at mouse location
			if (shape.equals("Line")) {
				double width = Double.parseDouble(width_field.getText());
				Line line = new Line();
				line.setStartX(event.getX());
				line.setStartY(event.getY());
				line.setEndX(event.getX());
				line.setEndY(event.getY());
				line.setStrokeWidth(width);
				line.setStroke(get_color(red_slider, green_slider, blue_slider));
				collection.add_shape(line);
				draw_pane.getChildren().add(line);

			// creates new rect
			} else if (shape.equals("Rectangle")) {
				Rectangle rect = new Rectangle();
				x_origin = event.getX();
				y_origin = event.getY();
				rect.setHeight(0);
				rect.setWidth(0);
				rect.setX(x_origin);
				rect.setY(y_origin);
				rect.setFill(get_color(red_slider, green_slider, blue_slider));
				collection.add_shape(rect);
				draw_pane.getChildren().add(rect);

			// creates new ellipse
			} else {
				Ellipse ellipse = new Ellipse();
				ellipse.setCenterX(event.getX());
				ellipse.setCenterY(event.getY());
				ellipse.setFill(get_color(red_slider, green_slider, blue_slider));
				collection.add_shape(ellipse);
				draw_pane.getChildren().add(ellipse);
			}
		}
	}
	class UpdateShape implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			String shape = shapes_dropdown.getValue();

			// resize LINE
			if (shape.equals("Line")) {
				Line line = collection.get_lines().get(collection.get_lines().size()-1);
				line.setEndX(event.getX());
				line.setEndY(event.getY());

			// resize RECT
			} else if (shape.equals("Rectangle")) {
				Rectangle rect = collection.get_rects().get(collection.get_rects().size()-1);
				rect.setHeight(Math.abs(y_origin - event.getY()));
				rect.setWidth(Math.abs(x_origin - event.getX()));

				if (event.getX() < x_origin && event.getY() < y_origin) {
					rect.setX(event.getX());
					rect.setY(event.getY());
				} else if (event.getX() < x_origin) {
					rect.setX(event.getX());
				} else if (event.getY() < y_origin) {
					rect.setY(event.getY());
				} else {
					rect.setX(x_origin);
					rect.setY(y_origin);
				}

			// resize ELLIPSE
			} else {
				Ellipse ellipse = collection.get_ellipses().get(collection.get_ellipses().size() - 1);
				double x = Math.abs(ellipse.getCenterX() - event.getX());
				double y = Math.abs(ellipse.getCenterY() - event.getY());
				ellipse.setRadiusX(x);
				ellipse.setRadiusY(y);
			}
		}
	}

	class MoveShape implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			Translate translate = new Translate();
			Shape shape = (Shape) event.getSource();
			double x_mouse = event.getX();
			double y_mouse = event.getY();

			if (shape instanceof Line) {
				Line line = (Line) shape;
				double x_start = line.getStartX();
				double y_start = line.getStartY();
				double x_end = line.getEndX();
				double y_end = line.getEndY();
				double l_start = Math
						.sqrt(Math.pow(Math.abs(x_mouse - x_start), 2) + Math.pow(Math.abs(y_mouse - y_start), 2));
				double l_end = Math
						.sqrt(Math.pow(Math.abs(x_mouse - x_end), 2) + Math.pow(Math.abs(y_mouse - y_end), 2));
				if (l_start <= l_end) {
					line.setStartX(event.getX());
					line.setStartY(event.getY());
				} else {
					line.setEndX(event.getX());
					line.setEndY(event.getY());
				}

			} else if (shape instanceof Rectangle) {
				Rectangle rect = (Rectangle) shape;
				translate.setX(x_mouse - rect.getX());
				translate.setY(y_mouse - rect.getY());
				rect.getTransforms().add(translate);

			} else {
				Ellipse ellipse = (Ellipse) shape;
				translate.setX(x_mouse - ellipse.getCenterX());
				translate.setY(y_mouse - ellipse.getCenterY());
				ellipse.getTransforms().add(translate);
			}
		}
	}

	class DeleteShape implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			Shape shape = (Shape) event.getSource();

			if (shape instanceof Line) {
				Line line = (Line) shape;
				collection.remove_shape(line);
			} else if (shape instanceof Rectangle) {
				Rectangle rect = (Rectangle) shape;
				collection.remove_shape(rect);
			} else {
				Ellipse ellipse = (Ellipse) shape;
				collection.remove_shape(ellipse);
			}

			draw_pane.getChildren().remove(shape);
		}
	}

	class ActivateDrawer implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			manage_eventhandlers();
			toggle_line_options(); // needed to check if "line" is already selected or not

		}
	}

	class ActivateMover implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			manage_eventhandlers();
		}
	}

	class ActivateDeleter implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			manage_eventhandlers();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
