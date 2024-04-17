package com.example.easy_loan.service.serviceImpl;

import com.example.easy_loan.dto.BorrowerInfoResponseDTO;
import com.example.easy_loan.dto.EditUserProfileRequestDto;
import com.example.easy_loan.dto.EditUserProfileResponseDto;
import com.example.easy_loan.exception.ResourceNotFoundException;
import com.example.easy_loan.model.Borrower;
import com.example.easy_loan.model.ContactInfo;
import com.example.easy_loan.model.User;
import com.example.easy_loan.repository.BorrowerRepository;
import com.example.easy_loan.repository.ContactInfoRepository;
import com.example.easy_loan.repository.UserRepository;
import com.example.easy_loan.service.BorrowerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserProfileServiceImpl implements BorrowerService {
    @Autowired
    private final UserRepository userRepository;
    private final BorrowerRepository borrowerRepository;
    private final ContactInfoRepository contactInfoRepository;

    @Override
    @Transactional
    public EditUserProfileResponseDto editUserProfile(EditUserProfileRequestDto editUserProfileRequestDto){
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                User user = userRepository.findByUsername(username)
                               .orElseThrow(()-> new RuntimeException("USER NOT FOUND"));
                EditUserProfileResponseDto editUserProfileResponseDto = new EditUserProfileResponseDto();
                user.setLastName(editUserProfileRequestDto.getLastName());
                user.setFirstName(editUserProfileRequestDto.getFirstName());
                userRepository.save(user);
                editUserProfileResponseDto.setFirstName(user.getFirstName());
               editUserProfileResponseDto.setLastName(user.getLastName());
               return editUserProfileResponseDto;
            }

    @Override
    public BorrowerInfoResponseDTO getBorrowerInfo(Long borrowerId) {

        User user = userRepository.findById(borrowerId).orElse(null);
        Borrower borrower = borrowerRepository.findById(borrowerId).orElse(null);
        ContactInfo contactInfo = (ContactInfo) contactInfoRepository.findByUser(user).orElse(null);

        if (user != null && borrower != null) {
            return new BorrowerInfoResponseDTO(
                    user.getFirstName() + " " + user.getLastName(),
                    contactInfo.getPhoneNumber(),
                    borrower.getEmploymentStatus()
            );
        } else {
            throw new ResourceNotFoundException("Borrower not found with ID: " + borrowerId);
        }

    }
}
