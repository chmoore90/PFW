/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 10
 */

package lab10_ChloeMoore;

public class POBox {
    // variables
    private Letter[] letters;
    private int box_num;

    // constructors
    public POBox() {
    }

    public POBox(Letter[] letters, int box_num) {
        this.letters = letters;
        this.box_num = box_num;
    }

    public POBox(POBox box) {
        this.letters = box.letters;
        this.box_num = box.box_num;
    }

    // methods
    public int get_box_num() {
        return box_num;
    }

    public Letter[] get_Letters() {
        return letters;
    }

    public String get_box_vars() {
        String msg = "";
        for (Letter letter : letters) {
            msg = msg + letter.get_letter_vars();
        }
        return msg;
    }

    public boolean is_equal(POBox box) {
        if (this.letters == box.letters && this.box_num == box.box_num) {
            return true;
        } else {
            return false;
        }
    }
}
