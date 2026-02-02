package com.assignment1.enums;

public enum ErrorCode {
    EMAIL_ALREADY_EXISTED("errorCode.email.existed");

    private final String code ;

    ErrorCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
