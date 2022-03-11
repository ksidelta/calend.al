package com.ksidelta.calendal.main.services.plugin;

import com.ksidelta.calendal.main.domain.source.Source;

import java.util.List;
import java.util.Optional;

public interface EventsPlugin {
    List<Source> findSourcesBySearchString(String searchString);

    Optional<Source> findSourceById(String id);

    String getUniquePluginId();
}
