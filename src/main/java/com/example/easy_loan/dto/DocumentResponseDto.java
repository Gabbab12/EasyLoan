package com.example.easy_loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentResponseDto {
    private String governmentId;
    private String proofOfAddress;
}
