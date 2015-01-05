package com.beci.service.exception;

public class RequestResponseServiceException extends Exception {
    public RequestResponseServiceException() {

    }

    public RequestResponseServiceException(String message) {
        super(message);
    }

    public RequestResponseServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestResponseServiceException(Throwable cause) {
        super(cause);
    }
}
