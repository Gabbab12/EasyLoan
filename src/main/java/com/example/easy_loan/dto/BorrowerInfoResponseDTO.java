package com.example.easy_loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerInfoResponseDTO {
    private String name;
    private String phoneNumber;
    private String employmentStatus;
    private Integer creditScore;
    private String otherDocuments;
    private String incomeStatementLink;

    public BorrowerInfoResponseDTO(String name, String phoneNumber, String employmentStatus) {

    }
}
