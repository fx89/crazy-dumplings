package com.crazydumplings.backend.security.exception;

import com.crazydumplings.exception.CrazyDumplingsException;

public class CrazyDumplingsSecurityException extends CrazyDumplingsException {

    public CrazyDumplingsSecurityException(String message) {
        super(message);
    }

    public CrazyDumplingsSecurityException(String message, Exception source) {
        super(message, source);
    }

}
