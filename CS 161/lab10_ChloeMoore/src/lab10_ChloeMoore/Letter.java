/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 10
 */

package lab10_ChloeMoore;

public class Letter {
    // variables
    private String sender;
    private boolean printed_matter;

    // constructors
    public Letter(String sender, boolean print) {
        this.sender = sender;
        this.printed_matter = print;
    }

    public Letter(Letter letter) {
        this.sender = letter.sender;
        this.printed_matter = letter.printed_matter;
    }

    // methods
    public String get_letter_vars() {
        return String.format("%s\t\t%b\n", sender, printed_matter);
    }

    public boolean is_equal(Letter letter) {
        if (this.sender.equals(letter.sender) && this.printed_matter == letter.printed_matter) {
            return true;
        } else {
            return false;
        }
    }
}
