package com.triad.bots.business;

import com.triad.bots.entity.Bot;
import com.triad.bots.repository.BotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BotBusiness {

    @Autowired
    private BotRepository repository;

    public Bot getBot(UUID id) {
        return this.repository.findById(id).orElseThrow(() ->
            new RuntimeException("Bot not found!")
        );
    }

    public Bot createBot(Bot bot) {
        this.validateBotName(bot);
        return this.repository.save(bot);
    }

    private void validateBotName(Bot bot) {
        if (bot.getName() == null) {
            throw new RuntimeException("Empty name of bot!");
        }
    }

    public Bot updateBot(UUID id, Bot bot) {
        bot.setId(id);
        this.validateBotName(bot);
        return this.repository.save(bot);
    }

    public void deleteBot(UUID id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Bot not found!");
        }
    }
}
