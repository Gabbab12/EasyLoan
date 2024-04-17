package com.example.easy_loan.service;

import org.springframework.http.ResponseEntity;

public interface DatabaseSeedService {
    ResponseEntity<?> seedBanks();
}
