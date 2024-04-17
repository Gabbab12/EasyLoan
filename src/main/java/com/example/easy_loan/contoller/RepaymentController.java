package com.example.easy_loan.contoller;

import com.example.easy_loan.dto.CreateRecipientDto;
import com.example.easy_loan.dto.InitiateTransferDto;
import com.example.easy_loan.exception.ResourceNotFoundException;
import com.example.easy_loan.model.BankAccount;
import com.example.easy_loan.service.serviceImpl.RepaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan-repayment")
@RequiredArgsConstructor
@Slf4j
public class RepaymentController {

    private final RepaymentServiceImpl repaymentService;


    @PostMapping("/initialize/{loanRequestId}")
    public ResponseEntity<?> initializeTransaction(@RequestBody InitiateTransferDto initiateTransferDto, @PathVariable Long loanRequestId) {
        try {
            return repaymentService.initializeTransaction(initiateTransferDto, loanRequestId);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/verify-account-details")
    public ResponseEntity<String> verifyAccountDetails(@RequestBody CreateRecipientDto createRecipientDto) {
        try {
            String bankHolderName = repaymentService.verifyAccountDetailsAndSetup(createRecipientDto);
            return new ResponseEntity<>(bankHolderName, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("An error occurred during bank holder name generation: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/save-bank-account")
    public ResponseEntity<BankAccount> saveBankAccount(@RequestBody CreateRecipientDto createRecipientDto) {
        try {
            BankAccount savedBankAccount = repaymentService.saveVerifiedAccount(createRecipientDto);
            return new ResponseEntity<>(savedBankAccount, HttpStatus.OK);
        } catch (Exception e) {
            log.error("An error occurred during saving bank account details: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

