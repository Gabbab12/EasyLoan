package com.example.easy_loan.mapper;


import com.example.easy_loan.dto.LoanOfferResponse;
import com.example.easy_loan.model.LoanOffer;

public class LoanMapper {
    public static LoanOfferResponse mapToLoanOfferResponse(LoanOffer loanoffer, LoanOfferResponse loanOfferResponse){
        loanOfferResponse.setAmount (loanoffer.getOfferAmount());
        loanOfferResponse.setDate(loanoffer.getDate());
        loanOfferResponse.setPaymentMethod(loanoffer.getPaymentMethod());
        loanOfferResponse.setDescription(loanoffer.getDescription ());
        return loanOfferResponse;
    }
}
