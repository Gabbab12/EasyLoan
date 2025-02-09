package com.example.easy_loan.service.serviceImpl;


import com.example.easy_loan.dto.DocumentResponseDto;
import com.example.easy_loan.model.ContactInfo;
import com.example.easy_loan.model.GovernmentID;
import com.example.easy_loan.model.User;
import com.example.easy_loan.repository.ContactInfoRepository;
import com.example.easy_loan.repository.GovernmentIDRepository;
import com.example.easy_loan.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final GovernmentIDRepository governmentIDRepository;
    private final ContactInfoRepository contactInfoRepository;

    @Override
    public DocumentResponseDto getUserDocuments() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        DocumentResponseDto documentResponseDTO = new DocumentResponseDto();
        Optional governmentId = governmentIDRepository.findByUser(user);
        Optional contactInfo = contactInfoRepository.findByUser(user);

        if (governmentId.isPresent()) {
            GovernmentID governmentID1 = (GovernmentID) governmentId.get();
            documentResponseDTO.setGovernmentId(governmentID1.getFileName());
        }
        if (contactInfo.isPresent()) {
            ContactInfo contactInfo1 = (ContactInfo) contactInfo.get();
            documentResponseDTO.setProofOfAddress(contactInfo1.getFileName());
        }
        return documentResponseDTO;
    }

    @Override
   public void deleteDocuments(String documentType) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if (documentType.equals("governmentId")) {
            Optional governmentIdOptional = governmentIDRepository.findByUser(user);
            if (governmentIdOptional.isPresent()) {
                GovernmentID governmentID = (GovernmentID) governmentIdOptional.get();
                governmentIDRepository.delete(governmentID);
            }
        } else if (documentType.equals("proofOfAddress")) {
            Optional contactInfoOptional = contactInfoRepository.findByUser(user);
            if (contactInfoOptional.isPresent()) {
                ContactInfo contactInfo = (ContactInfo) contactInfoOptional.get();
                contactInfoRepository.delete(contactInfo);

            }
        }
    }
}
