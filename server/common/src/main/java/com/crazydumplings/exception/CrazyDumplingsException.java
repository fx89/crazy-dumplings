package com.crazydumplings.exception;

public class CrazyDumplingsException extends RuntimeException {
    public CrazyDumplingsException(String message) {
        super(message);
    }

    public CrazyDumplingsException(String message, Exception source) {
        super(message, source);
    }
}
