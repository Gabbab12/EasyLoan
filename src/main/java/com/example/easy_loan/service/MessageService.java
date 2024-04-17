package com.example.easy_loan.service;

import com.example.easy_loan.dto.MessageDto;
import com.example.easy_loan.exception.RecipientNotFoundException;
import com.example.easy_loan.model.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(MessageDto messageDto, List<String> imageUrl) throws RecipientNotFoundException;

    void registerFcmToken(Long userId, String fcmToken);

    List<MessageDto> getAllMessages(Integer pageNo, Integer pageSize);

    List<MessageDto> getConversationMessages(Long targetSenderId, Integer pageNo, Integer pageSize);
}
