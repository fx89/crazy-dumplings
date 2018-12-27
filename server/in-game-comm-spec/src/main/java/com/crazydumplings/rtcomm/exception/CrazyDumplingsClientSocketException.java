package com.crazydumplings.rtcomm.exception;

public class CrazyDumplingsClientSocketException extends CrazyDumplingsInGameCommException {

    public CrazyDumplingsClientSocketException(String message) {
        super(message);
    }

    public CrazyDumplingsClientSocketException(String message, Exception source) {
        super(message, source);
    }

}
