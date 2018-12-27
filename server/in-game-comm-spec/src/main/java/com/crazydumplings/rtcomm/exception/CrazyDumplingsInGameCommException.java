package com.crazydumplings.rtcomm.exception;

import com.crazydumplings.exception.CrazyDumplingsException;

public class CrazyDumplingsInGameCommException extends CrazyDumplingsException {

    public CrazyDumplingsInGameCommException(String message) {
        super(message);
    }

    public CrazyDumplingsInGameCommException(String message, Exception source) {
        super(message, source);
    }
}
