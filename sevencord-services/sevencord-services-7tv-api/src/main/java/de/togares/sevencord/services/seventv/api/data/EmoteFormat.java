package de.togares.sevencord.services.seventv.api.data;

public enum EmoteFormat {
    WEBP("WEBP"), AVIF("AVIF");
    private final String format;

    EmoteFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
