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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    private final UserRepository userRepository;
    private final BorrowerRepository borrowerRepository;
    private final ContactInfoRepository contactInfoRepository;
    @Override
    public EditUserProfileResponseDto editUserProfile(EditUserProfileRequestDto editUserProfileRequestDto) {
        return null;
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
        }else{
            throw new ResourceNotFoundException("Borrower not found with ID: " + borrowerId);
        }

    }
}
