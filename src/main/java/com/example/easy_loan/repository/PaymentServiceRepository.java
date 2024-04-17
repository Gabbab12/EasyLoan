package com.example.easy_loan.repository;

import com.example.easy_loan.model.TransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PaymentServiceRepository extends JpaRepository<TransactionInfo, Long>{
    Optional<TransactionInfo> findByReference(String reference);

}
