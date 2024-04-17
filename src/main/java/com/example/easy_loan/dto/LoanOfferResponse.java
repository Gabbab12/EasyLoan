package com.example.easy_loan.dto;

import com.example.easy_loan.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoanOfferResponse {
    private double amount;
    private String date;
    private PaymentMethod paymentMethod;
    private String description;

}
