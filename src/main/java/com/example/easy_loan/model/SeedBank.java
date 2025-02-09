package com.example.easy_loan.model;

import com.example.easy_loan.service.serviceImpl.DatabaseSeedServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication()
public class SeedBank implements CommandLineRunner {

    private final DatabaseSeedServiceImpl databaseSeedService;

    public SeedBank(DatabaseSeedServiceImpl databaseSeedService) {
        this.databaseSeedService = databaseSeedService;
    }

    @Override
    public void run(String[] args) throws Exception {
       databaseSeedService.seedBanks();
    }
}
