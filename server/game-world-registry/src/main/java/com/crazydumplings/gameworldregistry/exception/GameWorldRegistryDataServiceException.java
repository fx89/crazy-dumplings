package com.crazydumplings.gameworldregistry.exception;

public class GameWorldRegistryDataServiceException extends CrazyDumplingsGameWorldRegistryException {

    public GameWorldRegistryDataServiceException(String message) {
        super(message);
    }

    public GameWorldRegistryDataServiceException(String message, Exception source) {
        super(message, source);
    }

}
