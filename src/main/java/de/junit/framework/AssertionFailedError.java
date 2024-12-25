package de.junit.framework;

public class AssertionFailedError extends Error {

    public AssertionFailedError() {
        super();
    }

    public AssertionFailedError(String message) {
        super(message);
    }

    public AssertionFailedError(String message, Throwable cause) {
        super(message, cause);
    }
}
