package com.triad.bots.controllers;

import com.triad.bots.business.BotBusiness;
import com.triad.bots.common.HttpRestResponse;
import com.triad.bots.entity.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/bots")
public class BotsController {

    @Autowired
    private BotBusiness botBusiness;

    @GetMapping("{botId}")
    public Bot getBot(@PathVariable UUID botId) {
        return this.botBusiness.getBot(botId);
    }

    @PostMapping
    public Bot createBot(@RequestBody Bot bot) {
        return this.botBusiness.createBot(bot);
    }

    @PutMapping("{botId}")
    public Bot updateBot(@PathVariable UUID botId, @RequestBody Bot bot) {
        return this.botBusiness.updateBot(botId, bot);
    }

    @DeleteMapping("{botId}")
    public HttpRestResponse deleteBot(@PathVariable UUID botId) {
        this.botBusiness.deleteBot(botId);
        return new HttpRestResponse("Bot successfully deleted!");
    }
}
