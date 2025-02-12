package de.togares.sevencore.services.seventv.core.api.data.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.togares.sevencord.services.seventv.api.data.seventv.EmoteFile;

import java.util.List;

public abstract class EmoteHostMixin {
    @JsonProperty("url")
    private String url;
    @JsonProperty("files")
    private List<EmoteFile> files;

}

