package de.togares.sevencore.services.seventv.core.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.togares.sevencord.services.seventv.api.data.EmoteSize;
import de.togares.sevencord.services.seventv.api.data.seventv.Emote;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteSet;
import de.togares.sevencore.services.seventv.core.model.CachedEmote;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Component
public class SevenTVApiClient {

    private static final String BASE_URL = "https://7tv.io/v3";
    private static final String F_EMOTE_SET_ENDPOINT = BASE_URL + "/emote-sets/%s";
    private static final String F_CDN_EMOTE = "https://cdn.7tv.app/emote/%s/%s";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmoteCache cache;

    @PostConstruct
    private void loadGlobalEmotes() throws IOException {
        EmoteSet emoteSet = loadEmoteSet("global");
        cacheEmoteSet(emoteSet);
    }

    public EmoteSet loadEmoteSet(String name) throws IOException {
        URL url = new URL(F_EMOTE_SET_ENDPOINT.formatted(name));
        URLConnection connection = url.openConnection();
        connection.connect();
        byte[] bytes = connection.getInputStream().readAllBytes();
        return objectMapper.readValue(bytes, EmoteSet.class);
    }

    public byte[] loadEmoteFile(CachedEmote emote) throws IOException {
        URL url = new URL(F_CDN_EMOTE.formatted(emote.getEmoteId(), emote.getName()));
        URLConnection connection = url.openConnection();
        connection.connect();
        byte[] bytes = connection.getInputStream().readAllBytes();
        emote.setBytes(bytes);
        return bytes;
    }

    private void cacheEmoteSet(EmoteSet emoteSet) {
        for (Emote emote : emoteSet.getEmotes()) {
            emote.getData().getHost().getFiles()
                    .forEach(file -> cache.put(emote.getName(), file, emote.getId()));
        }
    }

}
