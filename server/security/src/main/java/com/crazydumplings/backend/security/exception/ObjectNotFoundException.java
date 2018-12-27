package com.crazydumplings.backend.security.exception;

public class ObjectNotFoundException extends CrazyDumplingsSecurityException {

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Exception source) {
        super(message, source);
    }

}
