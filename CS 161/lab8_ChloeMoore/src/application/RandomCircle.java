package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class RandomCircle extends Circle {
    // circle variables
    private final double WINDOW_HEIGHT = 400; // window dimensions, for determining max x and y coordinates
    private final double WINDOW_LENGTH = 600;

    private Random rand = new Random(); // random object to generate radii
    private TranslateTransition ttrans;

    // CIRCLE CONSTRUCTOR
    public RandomCircle() {
        setRadius(rand.nextDouble(5, 80));
        setFill(generate_color());
        setStroke(Color.BLACK);
        setOnMouseClicked(new ClickEvent());

        ttrans = start_animation();
    }

    // CLICK EVENT HANDLER
    class ClickEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent click) {
            ttrans.stop();
            send_to_center();
        }
    }

    // METHODS
    public TranslateTransition start_animation() {
        Duration duration = new Duration(rand.nextDouble(500, 5001)); // random time interval, between 0.5-5 secs
        TranslateTransition ttrans = new TranslateTransition(duration, this);
        double min = getRadius();
        double x_max = WINDOW_LENGTH - getRadius();
        double y_max = WINDOW_HEIGHT - getRadius();

        ttrans.setFromX(rand.nextDouble(min, x_max));
        ttrans.setFromY(rand.nextDouble(min, y_max));
        ttrans.setToX(rand.nextDouble(min, x_max));
        ttrans.setToY(rand.nextDouble(min, y_max));

        ttrans.setAutoReverse(true);
        ttrans.setCycleCount(Animation.INDEFINITE);
        ttrans.play();

        return ttrans;
    }

    public void send_to_center() {
        Duration duration = new Duration(1000);
        TranslateTransition tcenter = new TranslateTransition(duration, this);

        tcenter.setToX(WINDOW_LENGTH/2);
        tcenter.setToY(WINDOW_HEIGHT/2);
        tcenter.play();
    }

    public Color generate_color() {
        // generate and return a random color
        double red = rand.nextDouble();
        double green = rand.nextDouble();
        double blue = rand.nextDouble();
        return new Color(red, green, blue, 1);
    }
}
