package com.example.easy_loan.exception;

public class RecipientNotFoundException extends RuntimeException{
    public RecipientNotFoundException(String message) {
        super(message);
    }
}
