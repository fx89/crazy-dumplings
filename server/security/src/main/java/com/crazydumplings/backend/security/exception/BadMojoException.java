package com.crazydumplings.backend.security.exception;

public class BadMojoException extends CrazyDumplingsSecurityException {

    public BadMojoException(String message) {
        super(message);
    }

    public BadMojoException(String message, Exception source) {
        super(message, source);
    }
}
