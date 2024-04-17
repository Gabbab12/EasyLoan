package com.example.easy_loan.contoller;

import com.example.easy_loan.dto.FcmTokenRequest;
import com.example.easy_loan.dto.MessageDto;
import com.example.easy_loan.dto.MessageDtoWithImages;
import com.example.easy_loan.exception.RecipientNotFoundException;
import com.example.easy_loan.service.serviceImpl.MessageServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageServiceImpl messageService;

    @Autowired
    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDtoWithImages messageDtoWithImages) {
        try {
            String sentMessage = String.valueOf(messageService.createMessage(
                    messageDtoWithImages.getMessageDto(),
                    messageDtoWithImages.getImageUrls()
            ));
            return ResponseEntity.ok(sentMessage);
        } catch (RecipientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/save-fcm-token")
    public ResponseEntity<?> saveFcmToken(@RequestBody FcmTokenRequest fcmTokenRequest) {
        try {
            messageService.registerFcmToken(fcmTokenRequest.getUserId(), fcmTokenRequest.getFcmToken());
            return ResponseEntity.ok("FCM token saved successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get-all-messages")
    public ResponseEntity<List<MessageDto>> getLastMessagesFromUniqueSenders(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize
    ) {
        List<MessageDto> lastMessages = messageService.getAllMessages(pageNo, pageSize);
        return ResponseEntity.ok(lastMessages);
    }

    @GetMapping("/conversations/{receiverId}")
    public ResponseEntity<List<MessageDto>> getConversationWithSender(
            @PathVariable Long receiverId,
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize
    ) {
        List<MessageDto> conversationMessages = messageService.getConversationMessages(receiverId, pageNo, pageSize);
        return ResponseEntity.ok(conversationMessages);
    }
}

