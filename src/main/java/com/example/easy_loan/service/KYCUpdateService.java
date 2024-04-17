package com.example.easy_loan.service;


import com.example.easy_loan.dto.BorrowerKYCDto;
import com.example.easy_loan.dto.KYCUpdateResponseDto;
import com.example.easy_loan.dto.LenderKYCDto;

public interface KYCUpdateService {
    KYCUpdateResponseDto updateLenderKYC(LenderKYCDto lenderKYCDto);

    KYCUpdateResponseDto updateBorrowerKyc(BorrowerKYCDto borrowerKYCDto);
}
