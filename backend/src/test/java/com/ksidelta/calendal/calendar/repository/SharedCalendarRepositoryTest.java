package com.ksidelta.calendal.calendar.repository;

import com.ksidelta.calendal.calendar.domain.SharedCalendar;
import com.ksidelta.calendal.utils.tests.BasePostgresTest;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


class SharedCalendarRepositoryTest extends BasePostgresTest {
    @Autowired
    SharedCalendarRepository sharedCalendarRepository;


    @Test
    void whenCalendarIsSavedThenListCanBeFoundByUserId() throws MalformedURLException {
        SharedCalendar sharedCalendar = new SharedCalendar();
        sharedCalendar.userId = "XD";
        sharedCalendar.url = new URL("http://lol.pl");

        sharedCalendarRepository.save(sharedCalendar);
        var calendars = sharedCalendarRepository.findByUserId("XD");

        assertThat(calendars.size(), equalTo(1));
        assertThat(calendars.get(0).userId, equalTo("XD"));
        assertThat(calendars.get(0).url, equalTo(new URL("http://lol.pl")));
    }
}