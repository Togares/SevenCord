package de.togares.sevencore.services.seventv.core.api.data.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteHost;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteOwner;

import java.util.List;

public abstract class EmoteDataMixin {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("flags")
    private long flags;
    @JsonProperty("lifecycle")
    private long lifecycle;
    @JsonProperty("state")
    private List<String> state;
    @JsonProperty("listed")
    private boolean listed;
    @JsonProperty("animated")
    private boolean animated;
    @JsonProperty("owner")
    private EmoteOwner owner;
    @JsonProperty("host")
    private EmoteHost host;
}
