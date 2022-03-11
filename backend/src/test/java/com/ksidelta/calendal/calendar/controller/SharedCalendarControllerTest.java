package com.ksidelta.calendal.calendar.controller;

import com.ksidelta.calendal.auth.AuthService;
import com.ksidelta.calendal.calendar.service.SharedCalendarService;
import com.ksidelta.calendal.utils.tests.BasePostgresTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SharedCalendarControllerTest extends BasePostgresTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    SharedCalendarService sharedCalendarService;

    @MockBean
    AuthService authService;

    @BeforeEach
    public void setUpAuthService() {
        Mockito.when(authService.getCurrentUserId()).thenReturn("google|cringe");
    }

    @Test
    public void whenCalendarIsAddedToSharedThenItIsRetrievableViaService() throws MalformedURLException {
        var response =
                testRestTemplate.postForEntity(
                        "/api/calendar/shared",
                        new ShareCalendarDto("http://calendar.to/endpoint"),
                        Void.class
                );
        var calendars = sharedCalendarService.listMyCalendars();

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(calendars, Matchers.hasSize(1));
        assertThat(calendars.get(0).getUrl(), equalTo(new URL("http://calendar.to/endpoint")));
    }

    @Test
    public void whenCalendarIsAddedToSharedViaServiceThenItIsRetrievable() throws MalformedURLException {
        sharedCalendarService.addCalendar(new URL("http://calendar.to/endpoint"));

        var response =
                testRestTemplate.getForEntity(
                        "/api/calendar/shared/list",
                        SharedCalendarsDto.class
                );

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}