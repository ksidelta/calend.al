package com.ksidelta.calendal.calendar.controller;

import com.ksidelta.calendal.calendar.service.SharedCalendarDto;
import com.ksidelta.calendal.calendar.service.SharedCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/calendar/shared")
public class SharedCalendarController {
    @Autowired
    SharedCalendarService sharedCalendarService;

    @PostMapping
    public void addSharedCalendar(@RequestBody ShareCalendarDto shareCalendarDto) throws MalformedURLException {
        sharedCalendarService.addCalendar(new URL(shareCalendarDto.getUrl()));
    }

    @GetMapping(path = "/list")
    public SharedCalendarsDto listSharedCalendars() {
        return new SharedCalendarsDto(sharedCalendarService.listMyCalendars());
    }
}

class ShareCalendarDto {
    String url;

    public ShareCalendarDto() {
    }

    public ShareCalendarDto(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class SharedCalendarsDto {
    List<SharedCalendarDto> sharedCalendars;

    public SharedCalendarsDto() {
    }

    public SharedCalendarsDto(List<SharedCalendarDto> sharedCalendars) {
        this.sharedCalendars = sharedCalendars;
    }

    public List<SharedCalendarDto> getSharedCalendars() {
        return sharedCalendars;
    }

    public void setSharedCalendars(List<SharedCalendarDto> sharedCalendars) {
        this.sharedCalendars = sharedCalendars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedCalendarsDto that = (SharedCalendarsDto) o;
        return Objects.equals(sharedCalendars, that.sharedCalendars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharedCalendars);
    }
}