package com.crazydumplings.backend.security.exception;

import com.crazydumplings.gameworldregistry.exception.CrazyDumplingsGameWorldRegistryException;

public class CrazyDumplingsGameWorldRegistrySecurityException extends CrazyDumplingsGameWorldRegistryException {

    public CrazyDumplingsGameWorldRegistrySecurityException(String message) {
        super(message);
    }

    public CrazyDumplingsGameWorldRegistrySecurityException(String message, Exception source) {
        super(message, source);
    }

}
