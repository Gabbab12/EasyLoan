package com.example.easy_loan.service;
import com.example.easy_loan.dto.LendingOfferDto;
import com.example.easy_loan.dto.LoanRequestDTO;
import com.example.easy_loan.enums.LoanStatus;
import com.example.easy_loan.model.Earning;
import com.example.easy_loan.model.LoanRequest;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
  String loanRequest(LoanRequestDTO loanRequestDTO, Long loanOfferId);
  String acceptLoan(Long loanRequestId);

  List<LendingOfferDto> lendingOffers(Integer pageNo, Integer pageSize);

  Double getOutstandingBalance(Long userId, LoanStatus loanStatus);

    void updateLoanStatus(String reference, LoanStatus newStatus, LoanRequest loan);

  Double getLenderEarnings();

  List<Earning> getMonthlyEarningsByDate(LocalDate date);


    String approveLoanRequest(Long loanRequestId);

    Page<LoanRequest> getAllLoanRequests(Integer pageNo, Integer pageSize);

  LoanRequestDTO viewLoanRequest(Long id);
}
