package com.crazydumplings.exception;

public class CrazyDumplingsBadCodingException extends CrazyDumplingsException {

    public CrazyDumplingsBadCodingException(String message) {
        super(message);
    }

    public CrazyDumplingsBadCodingException(String message, Exception source) {
        super(message, source);
    }

}
