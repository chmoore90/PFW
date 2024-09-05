package application;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private ArrayList<Card> hand;
    private static Deck deck = new Deck();
    private Random rand = new Random();

    // constructor
    public Player() {
        hand = new ArrayList<>(); // instantiates a new hand
    }

    // methods
    public ArrayList<Card> get_hand() {
        return hand;
    }

    public int get_hand_value() {
        // adds card value of all cards in hand together
        int total = 0;
        for (Card card : hand) {
            total += card.get_value();
        }

        // looks for aces in deck. if there is one AND total is over 21, subtract 10 (as if A=1 instead of 11)
        for (Card card : hand) {
            if (card.get_face().equals("A") && total > 21) {
                total -= 10;
            }
        }

        return total;
    }

    public void clear_hand() {
        hand.clear();
    }

    public boolean stands(int opp_hand_value) {
        // determines whether or not computer dealer stands

        // always stand if dealer hand value > player hand value, or hand val over 19
        if (get_hand_value() > opp_hand_value || get_hand_value() >= 19) {
            return true;

        // if hand val 16 or over, randomly generate a 1 or 0. Simulates 50% chance
        } else if (get_hand_value() >= 16) {
            int result = rand.nextInt(0, 2);
            if (result == 1) {
                return true;
            } else {
                return false;
            }

        // otherwise, returns false
        } else {
            return false;
        }
    }

    public void hit() {
        if (hand.size() <= 12) {
            Card new_card = deck.deal_card();
            hand.add(new_card);
        } else {
            // I doubt this will ever trigger, but a console printout to let you know if it does.
            System.out.println("Error: No card dealt. Hand would exceed 12 cards");
        }
    }

    public boolean bust() {
        // is the hand a bust?
        if (get_hand_value() > 21) {
            return true;
        } else {
            return false;
        }
    }

    public Deck get_deck() {
        return deck;
    }
}
