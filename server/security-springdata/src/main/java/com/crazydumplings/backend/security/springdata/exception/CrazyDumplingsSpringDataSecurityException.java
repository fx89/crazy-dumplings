package com.crazydumplings.backend.security.springdata.exception;

import com.crazydumplings.backend.security.exception.CrazyDumplingsSecurityException;

public class CrazyDumplingsSpringDataSecurityException extends CrazyDumplingsSecurityException {

    public CrazyDumplingsSpringDataSecurityException(String message) {
        super(message);
    }

    public CrazyDumplingsSpringDataSecurityException(String message, Exception source) {
        super(message, source);
    }

}
