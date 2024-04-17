package com.example.easy_loan.repository;

import com.example.easy_loan.model.ContactInfo;
import com.example.easy_loan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
    Optional findByUser(User user);
}
