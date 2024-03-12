package org.example.smth;

public class EmptyElementException extends Exception {
    public EmptyElementException() {
        super();
    }
    public EmptyElementException(String message) {
        super(message);
    }
}
