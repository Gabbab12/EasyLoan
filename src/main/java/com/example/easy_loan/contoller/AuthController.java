package com.example.easy_loan.contoller;


import com.example.easy_loan.dto.AuthenticationResponse;
import com.example.easy_loan.dto.LoginDto;
import com.example.easy_loan.dto.UserDTO;
import com.example.easy_loan.dto.UserResponseDTO;
import com.example.easy_loan.service.serviceImpl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")

public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("/userReg")

    public ResponseEntity<UserResponseDTO> userReg(@RequestBody UserDTO userDTO) {
        return authService.userReg(userDTO);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginDto loginDto) {
        AuthenticationResponse response = authService.loginUser(loginDto);
        return ResponseEntity.ok().body(response);
    }
}
