package com.example.easy_loan.contoller;


import com.example.easy_loan.dto.BorrowerKYCDto;
import com.example.easy_loan.dto.DocumentResponseDto;
import com.example.easy_loan.dto.KYCUpdateResponseDto;
import com.example.easy_loan.dto.LenderKYCDto;
import com.example.easy_loan.service.DocumentService;
import com.example.easy_loan.service.KYCUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/kyc/update")
public class KycController {


    private final KYCUpdateService kycUpdate;
    private final DocumentService documentService;
    @PutMapping("/lender")
    public ResponseEntity<KYCUpdateResponseDto> updateLenderKYC(@RequestBody LenderKYCDto lenderKYCDto){
        return new ResponseEntity<>(kycUpdate.updateLenderKYC(lenderKYCDto), HttpStatus.OK);
    }

    @PostMapping("borrower")
    public ResponseEntity<KYCUpdateResponseDto> updateBorrowerKyc(@RequestBody BorrowerKYCDto borrowerKYCDto){
        return new ResponseEntity<>(kycUpdate.updateBorrowerKyc(borrowerKYCDto), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<DocumentResponseDto> getUserDocuments() {
        DocumentResponseDto documentResponseDto = documentService.getUserDocuments();
        return ResponseEntity.ok(documentResponseDto);
    }

    @DeleteMapping("/delete-document")
    public ResponseEntity<String> deleteUserDocuments(@RequestParam String documentType){
        if (documentType.equals("governmentId")) {
        documentService.deleteDocuments(documentType);
            return ResponseEntity.ok().body("Successfully deleted Government ID");
        }
        else if (documentType.equals("proofOfAddress")) {
            documentService.deleteDocuments(documentType);
            return ResponseEntity.ok().body("Successfully deleted Proof of Address");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found or already deleted");
    }

}
