package com.example.easy_loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDtoWithImages {
    private MessageDto messageDto;
    private List<String> imageUrls;
}

