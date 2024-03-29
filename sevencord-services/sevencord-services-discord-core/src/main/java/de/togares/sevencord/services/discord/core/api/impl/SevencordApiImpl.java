package de.togares.sevencord.services.discord.core.api.impl;

import de.togares.sevencord.services.discord.api.SevencordApi;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SevencordApiImpl implements SevencordApi {
    @Value("${sevencord.discord.token}")
    private String token;

    @Override
    public void initializeBot() {
        DiscordClient client = DiscordClient.create(token);
        client.login().flatMapMany(gateway ->
                        gateway.on(MessageCreateEvent.class))
                .map(MessageCreateEvent::getMessage)
                .filter(message -> "!ping".equals(message.getContent()))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("Pong!"))
                .blockLast();
    }
}
