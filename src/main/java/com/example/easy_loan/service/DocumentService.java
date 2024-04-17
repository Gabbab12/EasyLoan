package com.example.easy_loan.service;

import com.example.easy_loan.dto.DocumentResponseDto;

public interface DocumentService {
    DocumentResponseDto getUserDocuments();
    void deleteDocuments(String documentType);
}
