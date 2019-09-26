package com.triad.bots.controllers;

import com.triad.bots.business.MessageBusiness;
import com.triad.bots.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/messages")
public class MessagesController {

    @Autowired
    private MessageBusiness messageBusiness;

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return this.messageBusiness.createMessage(message);
    }

    @GetMapping()
    public List<Message> getMessagesFromConversation(@RequestParam("conversationId") UUID conversationId) {
        return this.messageBusiness.getMessagesFromConversation(conversationId);
    }

    @GetMapping("{messageId}")
    public Message getMessage(@PathVariable UUID messageId) {
        return this.messageBusiness.getMessage(messageId);
    }
}
