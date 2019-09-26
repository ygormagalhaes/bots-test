package com.triad.bots.business;

import com.triad.bots.entity.Message;
import com.triad.bots.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MessageBusiness {

    @Autowired
    private MessageRepository repository;

    public Message createMessage(Message message) {
        this.validateMessage(message);
        return this.repository.save(message);
    }

    private void validateMessage(Message message) {
        if (message.getConversationId() == null) {
            throw new RuntimeException("Empty conversation id!");
        }
        if (message.getTimestamp() == null) {
            throw new RuntimeException("Empty timestamp!");
        }
        if (message.getFrom() == null) {
            throw new RuntimeException("Empty 'from' data!");
        }
        if (message.getTo() == null) {
            throw new RuntimeException("Empty 'to' data!");
        }
        if (message.getText() == null) {
            throw new RuntimeException("Empty text!");
        }
    }

    public Message getMessage(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Message not found!"));
    }

    public List<Message> getMessagesFromConversation(UUID conversationId) {
        return this.repository.findByConversationId(conversationId);
    }

}
