package com.example.easy_loan.repository;

import com.example.easy_loan.model.ResetRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ResetPasswordRepo extends JpaRepository<ResetRequest, Long> {
    Optional<ResetRequest> findByResetToken(String resetToken);
}
