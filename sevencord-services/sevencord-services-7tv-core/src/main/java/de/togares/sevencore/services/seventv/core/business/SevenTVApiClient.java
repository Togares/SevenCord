package de.togares.sevencore.services.seventv.core.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.togares.sevencord.services.seventv.api.data.seventv.Emote;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteSet;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component
public class SevenTVApiClient {

    private static final String BASE_URL = "https://7tv.io/v3";
    private static final String F_EMOTE_SET_ENDPOINT = BASE_URL + "/emote-sets/%s";

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    private void loadGlobalEmotes() throws IOException {
        URL url = new URL(F_EMOTE_SET_ENDPOINT.formatted("global"));
        URLConnection connection = url.openConnection();
        connection.connect();
        byte[] bytes = connection.getInputStream().readAllBytes();
        EmoteSet emoteSet = objectMapper.readValue(bytes, EmoteSet.class);

        List<Emote> emotes = emoteSet.getEmotes();
    }
}
