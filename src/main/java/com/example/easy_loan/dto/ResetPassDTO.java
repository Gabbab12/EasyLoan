package com.example.easy_loan.dto;

import lombok.Data;

@Data
public class ResetPassDTO {
    private String resetToken;
    private String newPassword;
    private String confirmPassword;
}
