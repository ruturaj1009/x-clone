package com.rutu.twitter.userms.utility;

public class ErrorInfo {
    private String errorMessage;
    private Integer errorCode;
    private ErrorType errorType;

    public ErrorInfo(String errorMessage, Integer errorCode, ErrorType errorType) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorType = errorType;
    }
}
