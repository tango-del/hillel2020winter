package Exceptions;

public class IndexOutOfException extends RuntimeException {
    public IndexOutOfException(String message) {
        super(message);
        //System.err.println(message);
    }
}
