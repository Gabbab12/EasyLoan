package com.example.easy_loan.dto;

import com.example.easy_loan.enums.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
    public class LenderLoanDisbursementDto {
        private String name;
        private String username;
        private PaymentMethod paymentMethod;
        private List<LoanDisbursementDto> disbursementPayments;
}
