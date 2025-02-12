package de.togares.sevencord.services.seventv.api;

import de.togares.sevencord.services.seventv.api.data.EmoteFormat;
import de.togares.sevencord.services.seventv.api.data.EmoteSize;

import java.io.InputStream;

public interface SevenTVApi {
    InputStream getEmoteAsImage(String emoteName, EmoteSize size, EmoteFormat format);
}
