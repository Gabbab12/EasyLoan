package com.example.easy_loan.service;

import com.example.easy_loan.dto.AuthenticationResponse;
import com.example.easy_loan.dto.LoginDto;
import com.example.easy_loan.dto.UserDTO;
import com.example.easy_loan.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<UserResponseDTO> userReg(UserDTO userDTO);
    AuthenticationResponse loginUser(LoginDto loginDto);

    void logout();
}
