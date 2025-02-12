package de.togares.sevencore.services.seventv.core.model;

import de.togares.sevencord.services.seventv.api.data.EmoteSize;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteFile;

public class CachedEmote extends EmoteFile {
    private final String emoteId;
    private EmoteSize emoteSize;
    private byte[] bytes;

    public CachedEmote(EmoteFile file, EmoteSize emoteSize, String emoteId) {
        this.emoteId = emoteId;
        name = file.getName();
        staticName = file.getStaticName();
        width = file.getWidth();
        height = file.getHeight();
        frameCount = file.getFrameCount();
        size = file.getSize();
        format = file.getFormat();
        this.emoteSize = emoteSize;
    }

    public String getEmoteId() {
        return emoteId;
    }

    public EmoteSize getEmoteSize() {
        return emoteSize;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
