package com.ksidelta.calendal.main;

import com.ksidelta.calendal.main.domain.Event;
import com.ksidelta.calendal.main.domain.source.SimpleSource;
import com.ksidelta.calendal.main.services.plugin.EventsPlugin;
import com.ksidelta.calendal.main.services.plugin.SimpleEventsPlugin;
import com.ksidelta.calendal.main.services.source.SourceService;
import com.ksidelta.calendal.main.services.source.SourceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
public class MainConfiguration {
    @Bean
    public SourceService sourceService(List<EventsPlugin> allEventsPlugins) {
        return new SourceServiceImpl(allEventsPlugins);
    }

    @Bean
    public EventsPlugin mockPlugin() {
        return new SimpleEventsPlugin("mock", Arrays.asList(
                new SimpleSource("A", "Group A",
                        Arrays.asList(new Event("A", "Event A", "Event A description", Instant.now()))
                ),
                new SimpleSource("B", "Group B",
                        Arrays.asList(new Event("B", "Event B", "Event B description", Instant.now()))
                )
        ));
    }
}
