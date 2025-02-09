package com.example.easy_loan.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String email;
    private String message;
    private String firstName;
    private HttpStatus httpStatus;
}
