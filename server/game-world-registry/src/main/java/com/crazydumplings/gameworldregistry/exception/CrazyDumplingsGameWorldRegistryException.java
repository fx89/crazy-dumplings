package com.crazydumplings.gameworldregistry.exception;

import com.crazydumplings.exception.CrazyDumplingsException;

public class CrazyDumplingsGameWorldRegistryException extends CrazyDumplingsException {

    public CrazyDumplingsGameWorldRegistryException(String message) {
        super(message);
    }

    public CrazyDumplingsGameWorldRegistryException(String message, Exception source) {
        super(message, source);
    }

}
