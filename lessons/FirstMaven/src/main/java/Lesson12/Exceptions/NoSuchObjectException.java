package Lesson12.Exceptions;

public class NoSuchObjectException extends RuntimeException {
    private static final String VALID_MESSAGE = "No Such element: %s";
    public NoSuchObjectException(String message) {
        super(String.format(VALID_MESSAGE, message));
    }
}
