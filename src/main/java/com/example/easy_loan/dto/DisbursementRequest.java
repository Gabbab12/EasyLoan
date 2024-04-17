package com.example.easy_loan.dto;

import lombok.Data;

@Data
public class DisbursementRequest {
    private LoanDisbursementDto loanDisbursementDto;
    private CreateRecipientDto createRecipientDto;
}
