package com.assignment1.exception;

public abstract class BusinessException extends RuntimeException{
    protected BusinessException(String message) {
        super(message);
    }
}


