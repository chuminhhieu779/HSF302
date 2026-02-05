package com.assignment1.exception;

public class UserNotExistedException extends RuntimeException{

    public UserNotExistedException(String message) {
        super(message);
    }
}
