package com.example.easy_loan.dto;

import lombok.Data;

import java.util.Date;
@Data

public class LoanRequestDTO {



    private Double loanAmount;


    private Date date;


    private String purpose;

    private Double interestRate;

    private String supportingDocument;


//    private User user;
}
