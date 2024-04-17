package com.example.easy_loan.dto;

import lombok.Data;

@Data
public class ChangePasswordDto {
    private Long userId;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}
