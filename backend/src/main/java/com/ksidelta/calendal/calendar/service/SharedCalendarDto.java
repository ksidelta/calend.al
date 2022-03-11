package com.ksidelta.calendal.calendar.service;

import java.net.URL;
import java.util.Objects;

public class SharedCalendarDto {
    public SharedCalendarDto(Integer id, URL url) {
        this.id = id;
        this.url = url;
    }

    Integer id;
    URL url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedCalendarDto that = (SharedCalendarDto) o;
        return Objects.equals(id, that.id) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }
}
