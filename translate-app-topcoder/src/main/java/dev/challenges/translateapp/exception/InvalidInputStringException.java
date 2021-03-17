package dev.challenges.translateapp.exception;

public class InvalidInputStringException extends RuntimeException {

    public InvalidInputStringException(String message, Exception e) {
        super(message, e);
    }

}
