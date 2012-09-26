package com.clickconcepts.exception;

public class CustomException extends RuntimeException {

    public static final String BAD_VERSION_CODE = "1.2.3.4";

    private String errorCode;

    public CustomException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
