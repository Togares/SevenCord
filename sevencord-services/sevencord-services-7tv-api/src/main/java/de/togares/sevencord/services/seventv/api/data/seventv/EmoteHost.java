package de.togares.sevencord.services.seventv.api.data.seventv;

import java.util.List;

public class EmoteHost {
    private String url;
    private List<EmoteFile> files;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<EmoteFile> getFiles() {
        return files;
    }

    public void setFiles(List<EmoteFile> files) {
        this.files = files;
    }
}
