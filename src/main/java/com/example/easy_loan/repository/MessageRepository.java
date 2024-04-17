package com.example.easy_loan.repository;

import com.example.easy_loan.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderId(Long senderId);
    List<Message> findAllByUserId(Long senderId, Pageable pageable);
    List<Message> findAllBySenderIdAndReceiverId(Long currentUserId, Long receiverId, Pageable pageable);

    List<Message> findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverId(Long id, Long targetSenderId, Long targetSenderId1, Long id1, Pageable pageable);
}

