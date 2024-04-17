package com.example.easy_loan.service.serviceImpl;

import com.example.easy_loan.dto.MessageDto;
import com.example.easy_loan.exception.RecipientNotFoundException;
import com.example.easy_loan.model.Message;
import com.example.easy_loan.model.MessageMapper;
import com.example.easy_loan.model.User;
import com.example.easy_loan.repository.MessageRepository;
import com.example.easy_loan.repository.UserRepository;
import com.example.easy_loan.service.MessageService;
import com.example.easy_loan.service.UserService;
import com.google.firebase.messaging.FirebaseMessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final UserRepository userRepository;
    private final FcmService fcmService;
    private final MessageRepository messageRepository;
    private final UserService userService;
    private final MessageMapper messageMapper;
    private final EmailServiceImpl emailService;

    @Autowired
    public MessageServiceImpl(
            UserRepository userRepository,
            FcmService fcmService,
            MessageRepository messageRepository,
            UserService userService,
            MessageMapper messageMapper,
            EmailServiceImpl emailService) {
        this.userRepository = userRepository;
        this.fcmService = fcmService;
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.messageMapper = messageMapper;
        this.emailService = emailService;
    }

    @Override
    public Message createMessage(MessageDto messageDto, List<String> imageUrls) throws RecipientNotFoundException {
        User sender = userRepository.findById(messageDto.getSenderId())
                .orElseThrow(() -> new RecipientNotFoundException("Sender not found"));

        User receiver = userRepository.findById(messageDto.getReceiverId())
                .orElseThrow(() -> new RecipientNotFoundException("Recipient not found"));

        // Create and save the message
        Message message = messageMapper.convertToEntity(messageDto, sender, receiver);
        message.setMessageImages(imageUrls);


        Message savedMessage = messageRepository.save(message);

        emailService.sendEmail(receiver.getUsername(), "you are having a new message from "
                + receiver.getFirstName(), "you have a new message");
        // Send push notifications
        sendPushNotifications(savedMessage);

        return savedMessage;
    }

    private void sendPushNotifications(Message message) {
        Long senderId = message.getSenderId();
        User participant = userService.getUserById(senderId);

        if (participant != null) {
            String fcmToken = participant.getFcmToken();
            if (fcmToken != null && !fcmToken.isEmpty()) {
                try {
                    fcmService.sendNotification(fcmToken, "New Message", "You have a new message");
                } catch (FirebaseMessagingException e) {
                }
            }
        }
    }
    @Override
    public void registerFcmToken(Long userId, String fcmToken) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        user.setFcmToken(fcmToken);
        userRepository.save(user);
    }

    @Override
    public List<MessageDto> getAllMessages(Integer pageNo, Integer pageSize) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        System.out.println("Current User ID: " + currentUser.getId());

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("createdAt").descending());
        List<Message> result = messageRepository.findAllByUserId(currentUser.getId(), pageable);

//        List<MessageDto> messages = new ArrayList<>();

        System.out.println("Messages: " + result);
        System.out.println("Total Messages: " + result.size());

        List<MessageDto> messages = result.stream()
                .map(message -> new MessageDto(message.getSenderId(), currentUser.getId(), message.getContent()))
                .collect(Collectors.toList());

        return messages;
    }
@Override
    public List<MessageDto> getConversationMessages(Long receiverId, Integer pageNo, Integer pageSize) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User currentUser = (User) authentication.getPrincipal();

    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("createdAt").descending());
    List<Message> conversationMessages = messageRepository.findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverId(
            currentUser.getId(), receiverId, receiverId, currentUser.getId(), pageable);

    List<MessageDto> conversationMessageDtos = new ArrayList<>();

    for (Message message : conversationMessages) {
        MessageDto messageDto = new MessageDto(message.getSenderId(), message.getReceiverId(), message.getContent());
        conversationMessageDtos.add(messageDto);
    }

    return conversationMessageDtos;
    }
}
