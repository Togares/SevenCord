package de.togares.sevencord.services.seventv.api.data.seventv;

import java.util.List;

public class EmoteSet {
    private String id;
    private String name;
    private long flags;
    private List<String> tags;
    private boolean immutable;
    private boolean privileged;
    private List<Emote> emotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFlags() {
        return flags;
    }

    public void setFlags(long flags) {
        this.flags = flags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isImmutable() {
        return immutable;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = immutable;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public List<Emote> getEmotes() {
        return emotes;
    }

    public void setEmotes(List<Emote> emotes) {
        this.emotes = emotes;
    }
}
