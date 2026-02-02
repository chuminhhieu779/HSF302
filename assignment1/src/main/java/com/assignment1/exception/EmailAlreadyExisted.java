package com.assignment1.exception;

import com.assignment1.enums.ErrorCode;

public class EmailAlreadyExisted extends BusinessException{

    public EmailAlreadyExisted(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
