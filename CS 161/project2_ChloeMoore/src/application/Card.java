package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {
    // data fields
    // private static final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // I moved this to the Deck class. It didn't seem to serve a purpose here?
    private final int HEIGHT = 130;
    private String face;

    // constructor
    public Card(String face) {
        this.face = face;
        // Image image = new Image(String.format("file:src\\application\\cards\\%s.png", face)); // USE THIS ONE
        Image image = new Image(String.format("file:project2_ChloeMoore\\src\\application\\cards\\%s.png", face)); // alternate image path
        setImage(image);
        setFitHeight(HEIGHT);
        setPreserveRatio(true);

    }

    // methods
    public String get_face() {
        return face;
    }

    public int get_value() {
        // returns integer value of card's face.
        int face_int = 0;
        if (face.equals("A")) {
            face_int = 11;
        } else if (face.equals("J") || face.equals("Q") || face.equals("K")) {
            face_int = 10;
        } else {
            face_int = Integer.parseInt(face);
        }
        return face_int;
    }

}
