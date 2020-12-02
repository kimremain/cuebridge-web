package com.jcuesoft.cuebridge.common.exception;

public class UncheckedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UncheckedException() {
        super();
    }

    public UncheckedException(String message) {
        super(message);
    }

    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedException(Throwable cause) {
        super(cause);
    }
}
