package com.example.easy_loan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter

public class UserLoanNotApprovedException extends RuntimeException{

    private String message;
    private String status;

    public UserLoanNotApprovedException(String message, HttpStatus status) {
        this.message = message;
        this.status = String.valueOf(status);
    }
}
