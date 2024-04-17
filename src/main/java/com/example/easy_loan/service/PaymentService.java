package com.example.easy_loan.service;

import com.example.easy_loan.api.paystackpaymentverify.PaymentVerificationResponse;
import com.example.easy_loan.dto.BankNameResponse;
import com.example.easy_loan.dto.CreateRecipientDto;
import com.example.easy_loan.dto.DisbursementRequest;
import com.example.easy_loan.dto.LenderLoanDisbursementDto;
import com.example.easy_loan.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity<?> initializeTransaction(LenderLoanDisbursementDto loanDisbursementDto) throws ResourceNotFoundException;

    ResponseEntity<PaymentVerificationResponse> verifyTransaction(String reference) throws ResourceNotFoundException;

    ResponseEntity<BankNameResponse> getAllBanks();

    ResponseEntity<?> createRecipient(CreateRecipientDto createRecipientDto) throws ResourceNotFoundException;

    ResponseEntity<?> disburseLoan(DisbursementRequest disbursementRequest);
}
