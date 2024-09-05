package lab7_ChloeMoore;

public class InvalidZipException extends Exception {

    public InvalidZipException() {
        super("Invalid zip code.");
    }

    public InvalidZipException(int zip) {
        super(String.format("%d is not a valid zip code.", zip));
    }
}
