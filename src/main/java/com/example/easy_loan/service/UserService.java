package com.example.easy_loan.service;

import com.example.easy_loan.dto.ChangePasswordDto;
import com.example.easy_loan.dto.ResetPassDTO;
import com.example.easy_loan.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    void initiatePasswordRequest(String email);
    String resetPassword(ResetPassDTO resetPassDTO);
    ResponseEntity<String> changePassword(ChangePasswordDto changePasswordDto);
    boolean oldPasswordIsValid(User user, String oldPassword);

    User getUserById(Long senderId);
}
