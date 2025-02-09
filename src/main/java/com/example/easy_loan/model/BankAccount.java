package com.example.easy_loan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class BankAccount extends BaseEntity {
    private String bank;
    private Long accountNumber;
    private String accountName;

    @OneToOne
    private User user;
}
