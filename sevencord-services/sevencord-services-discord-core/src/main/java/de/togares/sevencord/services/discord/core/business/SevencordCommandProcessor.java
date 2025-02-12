package de.togares.sevencord.services.discord.core.business;

import de.togares.sevencord.services.seventv.api.data.EmoteFormat;
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

        // TODO Animated emotes are not displayed, only posted as downloadable attachment

        String emoteName = split[1];
        return message.getChannel().flatMap(channel -> {
            InputStream emoteAsImage = sevenTVApi.getEmoteAsImage(emoteName, EmoteSize.M, EmoteFormat.WEBP);
            MessageCreateSpec.Builder builder = MessageCreateSpec.builder();
            String fileName = "%s.%s".formatted(emoteName, EmoteFormat.WEBP.getFormat().toLowerCase());
            if (emoteAsImage == null) {
                emoteAsImage = sevenTVApi.getEmoteAsImage("FeelsDankMan", EmoteSize.S, EmoteFormat.WEBP);
                fileName = "%s.%s".formatted("FeelsDankMan", EmoteFormat.WEBP.getFormat().toLowerCase());
                builder.content("%s was not found.".formatted(emoteName));
            }
            builder.addFile(MessageCreateFields.File.of(fileName, emoteAsImage));
            MessageCreateSpec imgMessage = builder.build();
            return channel.createMessage(imgMessage);
        }).block();
    }
}
