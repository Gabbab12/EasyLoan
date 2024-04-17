package com.example.easy_loan.service;

import com.example.easy_loan.dto.CreateRecipientDto;
import com.example.easy_loan.dto.InitiateTransferDto;
import com.example.easy_loan.exception.ResourceNotFoundException;
import com.example.easy_loan.model.BankAccount;
import org.springframework.http.ResponseEntity;

public interface RepaymentService {
    ResponseEntity<?> initializeTransaction(InitiateTransferDto initiateTransferDto, Long loanRequestId) throws ResourceNotFoundException;

    String verifyAccountDetailsAndSetup(CreateRecipientDto createRecipientDto);

    BankAccount saveVerifiedAccount(CreateRecipientDto createRecipientDto);
}
