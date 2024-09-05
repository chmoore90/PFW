package application;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // moved here from the Card class. By creating the deck from this array, we guarantee no invalid inputs (assuming array is correct)
    private final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private ArrayList<Card> cards = new ArrayList<>();
    private Random rand = new Random();

    // constructor
    public Deck() {
        reset();
    }

    // methods
    public void reset() {
        // clears current deck and generates a new one, using FACES array
        cards.clear();
        for (String face : FACES) {
            for (int i = 0; i < 4; i++) {   // creates 4 copies of every card face
                Card card = new Card(face);
                cards.add(card);
            }
        }
    }

    public Card deal_card() {
        // randomly selects an index, removes card from deck at that index and returns card at that integer index
        int index = rand.nextInt(0, cards.size());
        Card next_card = cards.get(index);
        cards.remove(index);

        return next_card;
    }
}
