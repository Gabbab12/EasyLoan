package com.example.easy_loan.service;

import com.example.easy_loan.dto.BorrowerInfoResponseDTO;
import com.example.easy_loan.dto.EditUserProfileRequestDto;
import com.example.easy_loan.dto.EditUserProfileResponseDto;

public interface BorrowerService {
    EditUserProfileResponseDto editUserProfile(EditUserProfileRequestDto editUserProfileRequestDto);
    BorrowerInfoResponseDTO getBorrowerInfo(Long borrowerId);

}
