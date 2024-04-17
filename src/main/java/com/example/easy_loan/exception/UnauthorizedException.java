package com.example.easy_loan.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class UnauthorizedException extends RuntimeException{
    private String message;
    private String status;

    public UnauthorizedException(String message, HttpStatus status){
        this.message = message;
        this.status = String.valueOf(status);
    }
}
