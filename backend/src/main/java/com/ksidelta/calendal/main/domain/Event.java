package com.ksidelta.calendal.main.domain;

import java.time.Instant;

public class Event {
    String id;
    String title;
    String description;
    Instant time;
    // location - to be decided

    public Event(String id, String title, String description, Instant time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
