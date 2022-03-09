package com.ksidelta.calendal.calendar;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.ksidelta.calendal.calendar.repository")
@Configuration
public class CalendarConfiguration {
}
