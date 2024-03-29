package de.togares.sevencore.services.seventv.core.api.data.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.togares.sevencord.services.seventv.api.data.seventv.Emote;

import java.util.List;

public abstract class EmoteSetMixin {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("flags")
    private long flags;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("immutable")
    private boolean immutable;
    @JsonProperty("privileged")
    private boolean privileged;
    @JsonProperty("emotes")
    private List<Emote> emotes;

}
