package com.ksidelta.calendal.calendar.repository;

import com.ksidelta.calendal.calendar.domain.SharedCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SharedCalendarRepository extends JpaRepository<SharedCalendar, Integer> {
    List<SharedCalendar> findByUserId(String userId);
}
