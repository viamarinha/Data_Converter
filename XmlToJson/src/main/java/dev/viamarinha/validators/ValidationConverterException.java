package dev.viamarinha.validators;

public class ValidationConverterException extends Exception{
    public ValidationConverterException() {
    }

    public ValidationConverterException(String message) {
        super(message);
    }

    public ValidationConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
