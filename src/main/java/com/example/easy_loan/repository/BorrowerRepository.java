package com.example.easy_loan.repository;

import com.example.easy_loan.model.Borrower;
import com.example.easy_loan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    Optional<?> findByUser(User user);

}
