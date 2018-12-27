package com.crazydumplings.gameworldregistry.exception;

public class MissingSerializerDeserializerException extends CrazyDumplingsGameWorldRegistryException {

    public MissingSerializerDeserializerException(String message) {
        super(message);
    }

    public MissingSerializerDeserializerException(String message, Exception source) {
        super(message, source);
    }

}
