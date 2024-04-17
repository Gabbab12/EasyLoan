package com.example.easy_loan.dto;

import lombok.Data;

@Data
public class ApproveLoanResponse {
    private String message;
    private int statusCode;
    private String fullName;

}
