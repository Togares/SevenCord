package de.togares.sevencord.services.seventv.api.data.seventv;
import java.time.Instant;

public class Emote {
    private String id;
    private String name;
    private long flags;
    private Instant timestamp;
    private String actorId;
    private EmoteData data;

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

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public EmoteData getData() {
        return data;
    }

    public void setData(EmoteData data) {
        this.data = data;
    }

}
