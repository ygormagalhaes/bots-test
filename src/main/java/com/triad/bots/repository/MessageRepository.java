package com.triad.bots.repository;

import com.triad.bots.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {
    List<Message> findByConversationId(UUID conversationId);
}
