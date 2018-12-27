package com.crazydumplings.backend.security.exception;

public class CrazyDumplingsSecurityWrongImplementationException extends CrazyDumplingsSecurityException {

    public CrazyDumplingsSecurityWrongImplementationException(String message) {
        super(message);
    }

    public CrazyDumplingsSecurityWrongImplementationException(String message, Exception source) {
        super(message, source);
    }

}
