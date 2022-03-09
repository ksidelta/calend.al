package com.ksidelta.calendal.calendar.domain;

import com.ksidelta.calendal.utils.hibernate.URLConverter;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "shared_calendars")
public class SharedCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String userId;

    @Convert(converter = URLConverter.class)
    public URL url;
}
