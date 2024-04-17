package com.example.easy_loan.contoller;


import com.example.easy_loan.dto.BorrowerInfoResponseDTO;
import com.example.easy_loan.dto.EditUserProfileRequestDto;
import com.example.easy_loan.dto.EditUserProfileResponseDto;
import com.example.easy_loan.service.serviceImpl.BorrowerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class UserProfileController {
    private final BorrowerServiceImpl borrowerService;
    @PostMapping("/edit/profile")
    public ResponseEntity<EditUserProfileResponseDto> editUserProfile(@RequestBody EditUserProfileRequestDto editUserProfileRequestDto){
                    EditUserProfileResponseDto responseDto = borrowerService.editUserProfile(editUserProfileRequestDto);
                   return  new ResponseEntity<>(responseDto, HttpStatus.CREATED);
                }
    @GetMapping("/{borrowerId}")
    public ResponseEntity<BorrowerInfoResponseDTO> getBorrowerInfo(@PathVariable Long borrowerId) {
        BorrowerInfoResponseDTO borrowerInfo = borrowerService.getBorrowerInfo(borrowerId);
        if (borrowerInfo != null) {
            return ResponseEntity.ok(borrowerInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }
