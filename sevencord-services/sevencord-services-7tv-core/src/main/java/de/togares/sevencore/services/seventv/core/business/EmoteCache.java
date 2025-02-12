package de.togares.sevencore.services.seventv.core.business;

import de.togares.sevencord.services.seventv.api.data.EmoteSize;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteFile;
import de.togares.sevencore.services.seventv.core.model.CachedEmote;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("singleton")
public class EmoteCache {

    private Map<String, List<CachedEmote>> cache = new HashMap<>();

    public boolean put(String name, EmoteFile file, String emoteId) {
        EmoteSize size = null;
        switch (file.getHeight()) {
            case 32 -> size = EmoteSize.XS;
            case 64 -> size = EmoteSize.S;
            case 96 -> size = EmoteSize.M;
            case 128 -> size = EmoteSize.L;
        }
        CachedEmote cachedEmote = new CachedEmote(file, size, emoteId);
        final EmoteSize finalSize = size;
        List<CachedEmote> list = cache.getOrDefault(name, new ArrayList<>());
        if (list.stream().filter(c -> c.getEmoteSize() == finalSize && c.getFormat().equalsIgnoreCase(cachedEmote.getFormat())).findAny().isEmpty()) {
            list.add(cachedEmote);
            cache.put(name, list);
            return true;
        }
        return false;
    }

    public CachedEmote get(String name, EmoteSize size, String format) {
        List<CachedEmote> cachedEmotes = cache.get(name);
        if (cachedEmotes == null) {
            return null;
        }
        return cachedEmotes.stream().filter(emote -> emote.getEmoteSize() == size && emote.getFormat().equalsIgnoreCase(format))
                .findFirst().orElse(null);
    }
}
