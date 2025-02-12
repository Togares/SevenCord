package de.togares.sevencord.services.discord.core.business;

import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class SevencordMessageFilter {
    public static final String COMMAND_PREFIX = "!sc";

    public boolean isSevencordCommand(Message message) {
        return message.getContent().startsWith(COMMAND_PREFIX);
    }

}
