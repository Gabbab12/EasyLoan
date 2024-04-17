package com.example.easy_loan.service;

import com.example.easy_loan.dto.EmailDTO;

public interface EmailService {
    void sendEmailAlert(EmailDTO emailDTO);
}
