package com.example.easy_loan.repository;

import com.example.easy_loan.model.GovernmentID;
import com.example.easy_loan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GovernmentIDRepository extends JpaRepository<GovernmentID, Long> {
    Optional findByUser(User user);
}
