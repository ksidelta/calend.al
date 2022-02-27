package com.ksidelta.calendal.main.domain.source;


import com.ksidelta.calendal.main.domain.Event;

import java.util.List;

public class SimpleSource extends Source {
    List<Event> events;

    public SimpleSource(String id, String sourceName, List<Event> events) {
        super(id, sourceName);
        this.events = events;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }
}
