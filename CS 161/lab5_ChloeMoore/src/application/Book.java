package application;

public class Book {
    // properties of the book class
    public String title;
    public double price;

    // constructor that takes and assigns book title and price
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String toString() {
        return String.format("%s", title);
    }
}
