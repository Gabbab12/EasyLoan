package com.example.easy_loan.dto;

import com.example.easy_loan.enums.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class UserDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Role role;

}
