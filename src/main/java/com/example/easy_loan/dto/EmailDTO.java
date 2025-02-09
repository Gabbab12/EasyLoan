package com.example.easy_loan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;
}
