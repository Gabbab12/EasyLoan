package com.example.easy_loan.repository;

import com.example.easy_loan.model.Lender;
import com.example.easy_loan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LenderRepository extends JpaRepository<Lender, Long> {
    Optional findByUser(User user);
}
