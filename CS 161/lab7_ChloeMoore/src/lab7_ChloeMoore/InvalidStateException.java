package lab7_ChloeMoore;

public class InvalidStateException extends Exception {

    public InvalidStateException() {
        super("Invalid state name abbreviation.");
    }

    public InvalidStateException(String state) {
        super(String.format("%s is not a valid state abbreviation.", state.toUpperCase()));
    }
}
