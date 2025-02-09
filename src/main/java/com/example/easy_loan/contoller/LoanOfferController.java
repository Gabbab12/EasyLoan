package com.example.easy_loan.contoller;

import com.example.easy_loan.dto.ApiResponse;
import com.example.easy_loan.dto.LoanOfferDTO;
import com.example.easy_loan.dto.LoanOfferResponse;
import com.example.easy_loan.model.LoanOffer;
import com.example.easy_loan.service.LoanOfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loan")
@Slf4j
public class LoanOfferController {

    private final LoanOfferService loanOfferService;
    @PostMapping("/create-loan-offer")
    public ResponseEntity<ApiResponse<LoanOffer>> createLoanOffer(@RequestBody LoanOfferDTO loanOfferDTO){
        return loanOfferService.createLoanOffer (loanOfferDTO);
    }
    @GetMapping("my-loan-offers")
    public ApiResponse<List<LoanOfferResponse>> getLoanOffersByUsername(@PathVariable Long id) {
        return loanOfferService.getLoanOffersByUsername();
    }
}
