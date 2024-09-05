package application;

import java.util.ArrayList;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ShapeCollection {
    // arraylists for shapes
    private ArrayList<Line> lines;
    private ArrayList<Rectangle> rectangles;
    private ArrayList<Ellipse> ellipses;

    // constructor
    ShapeCollection() {
        lines = new ArrayList<>();
        rectangles = new ArrayList<>();
        ellipses = new ArrayList<>();
    }

    // methods
    public void add_shape(Shape shape) {
        if (shape instanceof Line) {
            Line line = (Line) shape;
            lines.add(line);

        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            rectangles.add(rect);

        } else {
            Ellipse ellipse = (Ellipse) shape;
            ellipses.add(ellipse);
        }
    }

    public void remove_shape(Shape shape) {
        if (shape instanceof Line) {
            Line line = (Line) shape;
            lines.remove(line);

        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            rectangles.remove(rect);

        } else {
            Ellipse ellipse = (Ellipse) shape;
            ellipses.remove(ellipse);
        }
    }

    public ArrayList<Line> get_lines() {
        return lines;
    }

    public ArrayList<Rectangle> get_rects() {
        return rectangles;
    }

    public ArrayList<Ellipse> get_ellipses() {
        return ellipses;
    }

    public ArrayList<Shape> get_all_shapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.addAll(lines);
        shapes.addAll(rectangles);
        shapes.addAll(ellipses);

        return shapes;
    }
}
