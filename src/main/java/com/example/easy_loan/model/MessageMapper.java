package com.example.easy_loan.model;

import com.example.easy_loan.dto.MessageDto;
import com.example.easy_loan.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    private final ModelMapper modelMapper;

    public MessageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Message convertToEntity(MessageDto messageDto, User sender, User receiver) {

        Message message = modelMapper.map(messageDto, Message.class);
        message.setStatus(Status.UNREAD);
        message.setUser(sender);
        return message;
    }
}
