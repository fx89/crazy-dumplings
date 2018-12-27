package com.crazydumplings.backend.security.exception;

public class ObjectAlreadyExistsException extends CrazyDumplingsSecurityException {

    public ObjectAlreadyExistsException(String message) {
        super(message);
    }

    public ObjectAlreadyExistsException(String message, Exception source) {
        super(message, source);
    }

}
