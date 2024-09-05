package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CircleCatcher extends Application {

	@Override
	public void start(Stage stage) throws InterruptedException {
		int size = 10;
		RandomCircle[] circles = new RandomCircle[size];
		for (int i=0; i<size; i++) {
			circles[i] = new RandomCircle();
		}




		Pane pane = new Pane(circles);
		pane.setPrefSize(600, 400);

		Scene scene = new Scene(pane);
		stage.setTitle("Circle Wrangler");
		stage.setScene(scene);
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
