package de.togares.sevencore.services.seventv.core.api.impl;

import de.togares.sevencord.common.logging.Loggable;
import de.togares.sevencord.services.seventv.api.SevenTVApi;
import de.togares.sevencord.services.seventv.api.data.EmoteFormat;
import de.togares.sevencord.services.seventv.api.data.EmoteSize;
import de.togares.sevencore.services.seventv.core.business.EmoteCache;
import de.togares.sevencore.services.seventv.core.business.SevenTVApiClient;
import de.togares.sevencore.services.seventv.core.model.CachedEmote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class SevenTVApiImpl implements SevenTVApi, Loggable {
    @Autowired
    private SevenTVApiClient apiClient;
    @Autowired
    private EmoteCache cache;

    @Override
    public InputStream getEmoteAsImage(String emoteName, EmoteSize size, EmoteFormat format) {

        CachedEmote cachedEmote = cache.get(emoteName, size, format.getFormat());
        if (cachedEmote == null) {
            return null;
        }

        byte[] bytes = cachedEmote.getBytes();
        if (bytes == null) {
            try {
                bytes = apiClient.loadEmoteFile(cachedEmote);
            } catch (IOException e) {
                logger().error("Error while trying to load image for emote '%s'", emoteName, e);
                return null;
            }
        }

        return new ByteArrayInputStream(cachedEmote.getBytes());
    }
}
