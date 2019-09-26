package com.triad.bots.repository;

import com.triad.bots.entity.Bot;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BotRepository extends CrudRepository<Bot, UUID> {
}
