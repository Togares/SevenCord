package de.togares.sevencore.services.seventv.core.api.data.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class EmoteFileMixin {
    @JsonProperty("name")
     private String name;
    @JsonProperty("static_name")
    private String staticName;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;
    @JsonProperty("frame_count")
    private int frameCount;
    @JsonProperty("size")
    private long size;
    @JsonProperty("format")
    private String format;

}
