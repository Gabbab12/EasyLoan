package com.example.easy_loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KYCUpdateResponseDto {
    private String Msg;
    private Integer progress;

}
