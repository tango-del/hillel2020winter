package exceptions;

import loggers.CustomLogger;

public class UnsupportedSignException extends RuntimeException {
    public UnsupportedSignException(String message) {
        super(message);
    }
}
