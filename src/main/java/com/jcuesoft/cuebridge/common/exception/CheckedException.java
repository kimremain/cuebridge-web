package com.jcuesoft.cuebridge.common.exception;

public class CheckedException extends Exception {

    private static final long serialVersionUID = 1L;

    protected String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public CheckedException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public CheckedException(String errorCode, String message) {
        super(message);
    }

    public CheckedException(String errorCode, String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(String errorCode, Throwable cause) {
        super(cause);
    }
}
