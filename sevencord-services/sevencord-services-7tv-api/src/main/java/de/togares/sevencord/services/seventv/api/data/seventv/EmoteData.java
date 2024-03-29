package de.togares.sevencord.services.seventv.api.data.seventv;

import java.util.List;

public class EmoteData {
    private String id;
    private String name;
    private long flags;
    private long lifecycle;
    private List<String> state;
    private boolean listed;
    private boolean animated;
    private EmoteOwner owner;
    private EmoteHost host;

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

    public long getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(long lifecycle) {
        this.lifecycle = lifecycle;
    }

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public EmoteOwner getOwner() {
        return owner;
    }

    public void setOwner(EmoteOwner owner) {
        this.owner = owner;
    }

    public EmoteHost getHost() {
        return host;
    }

    public void setHost(EmoteHost host) {
        this.host = host;
    }
}
