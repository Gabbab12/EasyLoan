package com.example.easy_loan.repository;

import com.example.easy_loan.dto.LendingOfferDto;
import com.example.easy_loan.model.LoanOffer;
import com.example.easy_loan.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanOfferRepository extends JpaRepository<LoanOffer, Long> {
    List<LendingOfferDto> findAllByOfferStatus(String status, Pageable pageable);

    List<LoanOffer> findByUser(User user);

}
