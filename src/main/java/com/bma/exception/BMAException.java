package com.bma.exception;

public class BMAException extends RuntimeException {

    private int code;

    public BMAException(String msg) {
        super(msg);
    }

    public BMAException(int code, String message) {
        super(message);
        this.code = code;
    }


}
