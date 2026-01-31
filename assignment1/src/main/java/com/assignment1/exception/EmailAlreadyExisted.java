package com.assignment1.exception;

public class EmailAlreadyExisted extends BusinessException{
    public EmailAlreadyExisted(String message) {
        super(message);
    }
}
