package Lesson12.Exceptions;

public class IndexOutOfBoundException extends RuntimeException {
    public IndexOutOfBoundException(String message) {
        super(message);
        //System.err.println(message);
    }
}
