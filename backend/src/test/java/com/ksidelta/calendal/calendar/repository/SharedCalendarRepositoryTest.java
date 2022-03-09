package com.ksidelta.calendal.calendar.repository;

import com.ksidelta.calendal.calendar.domain.SharedCalendar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class SharedCalendarRepositoryTest {
    @Autowired
    SharedCalendarRepository sharedCalendarRepository;

    @Test
    void test() throws MalformedURLException {
        SharedCalendar sharedCalendar = new SharedCalendar();
        sharedCalendar.userId = "XD";
        sharedCalendar.url = new URL("http://lol.pl");

        sharedCalendarRepository.save(sharedCalendar);
    }
}