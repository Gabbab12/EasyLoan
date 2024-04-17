package com.example.easy_loan.service;

import com.example.easy_loan.dto.ApiResponse;
import com.example.easy_loan.dto.LoanOfferDTO;
import com.example.easy_loan.dto.LoanOfferResponse;
import com.example.easy_loan.model.LoanOffer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanOfferService {
    ResponseEntity<ApiResponse<LoanOffer>> createLoanOffer(LoanOfferDTO loanOfferDTO);
    ApiResponse<List<LoanOfferResponse>> getLoanOffersByUsername();
}