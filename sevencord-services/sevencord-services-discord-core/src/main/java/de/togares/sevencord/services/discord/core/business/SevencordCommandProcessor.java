package de.togares.sevencord.services.discord.core.business;

import de.togares.sevencord.services.seventv.api.data.EmoteSize;
import discord4j.core.object.entity.Message;
import discord4j.core.spec.MessageCreateFields;
import discord4j.core.spec.MessageCreateSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import de.togares.sevencord.services.seventv.api.SevenTVApi;

import java.io.InputStream;

@Component
public class SevencordCommandProcessor {
    private static final String SYNOPSIS = "Synopsis: !sc <emoteName>";
    @Autowired
    private SevenTVApi sevenTVApi;

    public Message processCommand(Message message) {

        String content = message.getContent();
        String[] split = content.split(" ");
        if (split.length == 1) {
            return message.getChannel().flatMap(channel -> channel.createMessage(SYNOPSIS)).block();
        }

        String emoteName = split[1];
        return message.getChannel().flatMap(channel -> {
            InputStream emoteAsImage = sevenTVApi.getEmoteAsImage(emoteName, EmoteSize.M);
            MessageCreateSpec imgMessage = MessageCreateSpec.builder()
                    .addFile(MessageCreateFields.File.of(emoteName, emoteAsImage))
                    .build();
            return channel.createMessage(imgMessage);
//            return channel.createMessage("Requested Emote: %s".formatted(emoteName));
        }).block();
    }
}
