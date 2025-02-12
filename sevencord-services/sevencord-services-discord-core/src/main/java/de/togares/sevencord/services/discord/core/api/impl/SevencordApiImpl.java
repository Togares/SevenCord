package de.togares.sevencord.services.discord.core.api.impl;

import de.togares.sevencord.services.discord.api.SevencordApi;
import de.togares.sevencord.services.discord.core.business.SevencordCommandProcessor;
import de.togares.sevencord.services.discord.core.business.SevencordMessageFilter;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SevencordApiImpl implements SevencordApi {
    @Value("#{environment.sevencordDiscordToken}")
    private String token;
    @Autowired
    private SevencordMessageFilter messageFilter;
    @Autowired
    private SevencordCommandProcessor commandProcessor;

    @Override
    public void initializeBot() {
        DiscordClient client = DiscordClient.create(token);
        client.login().flatMapMany(gateway ->
                        gateway.on(MessageCreateEvent.class))
                .map(MessageCreateEvent::getMessage)
                .filter(messageFilter::isSevencordCommand)
                .map(message -> commandProcessor.processCommand(message))
                .blockLast();
    }
}
