package com.example.easy_loan.repository;

import com.example.easy_loan.model.LoanRepaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepaymentHistoryRepository extends JpaRepository<LoanRepaymentHistory, Long> {
}
