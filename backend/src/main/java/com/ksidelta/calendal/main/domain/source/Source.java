package com.ksidelta.calendal.main.domain.source;

import com.ksidelta.calendal.main.domain.Event;

import java.util.List;

public abstract class Source {
    String id;
    String sourceName;

    public Source(String id, String sourceName) {
        this.id = id;
        this.sourceName = sourceName;
    }

    public abstract List<Event> getEvents();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
