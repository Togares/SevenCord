package de.togares.sevencore.services.seventv.core.api.data.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteData;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteHost;

import java.time.Instant;

public abstract class EmoteMixin {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("flags")
    private long flags;
    @JsonProperty("timestamp")
    private Instant timestamp;
    @JsonProperty("actor_id")
    private String actorId;
    @JsonProperty("data")
    private EmoteData data;
}
