package com.ksidelta.calendal.calendar.service;

import com.ksidelta.calendal.auth.AuthService;
import com.ksidelta.calendal.calendar.domain.SharedCalendar;
import com.ksidelta.calendal.calendar.repository.SharedCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SharedCalendarServiceImpl implements SharedCalendarService {
    @Autowired
    SharedCalendarRepository sharedCalendarRepository;

    @Autowired
    AuthService authService;

    @Override
    public void addCalendar(URL url) {
        var user = authService.getCurrentUserId();
        SharedCalendar sharedCalendar = new SharedCalendar();

        sharedCalendar.userId = user;
        sharedCalendar.url = url;

        sharedCalendarRepository.save(sharedCalendar);
    }

    @Override
    public List<SharedCalendarDto> listMyCalendars() {
        return sharedCalendarRepository
                .findByUserId(authService.getCurrentUserId()).stream()
                .map(calendar -> new SharedCalendarDto(calendar.id, calendar.url))
                .collect(Collectors.toList());
    }
}
