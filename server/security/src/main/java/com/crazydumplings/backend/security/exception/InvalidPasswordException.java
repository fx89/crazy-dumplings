package com.crazydumplings.backend.security.exception;

public class InvalidPasswordException extends CrazyDumplingsSecurityException {

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException(String message, Exception source) {
        super(message, source);
    }

}
