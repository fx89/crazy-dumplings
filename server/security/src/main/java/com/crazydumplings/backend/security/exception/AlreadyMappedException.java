package com.crazydumplings.backend.security.exception;

public class AlreadyMappedException extends CrazyDumplingsSecurityException {

    public AlreadyMappedException(String message) {
        super(message);
    }

    public AlreadyMappedException(String message, Exception source) {
        super(message, source);
    }

}
