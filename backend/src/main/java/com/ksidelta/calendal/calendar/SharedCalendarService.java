package com.ksidelta.calendal.calendar;

import java.net.URL;
import java.util.List;

public interface SharedCalendarService {
    void addCalendar(URL url);

    // void removeCalendar(Integer id);

    List<SharedCalendarDto> listMyCalendars();
}
