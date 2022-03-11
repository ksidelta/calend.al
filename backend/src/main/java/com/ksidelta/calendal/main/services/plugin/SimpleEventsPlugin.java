package com.ksidelta.calendal.main.services.plugin;

import com.ksidelta.calendal.main.domain.source.Source;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleEventsPlugin implements EventsPlugin {
    String pluginId;
    List<Source> sources;

    public SimpleEventsPlugin(String pluginId, List<Source> sources) {
        this.pluginId = pluginId;
        this.sources = sources;
    }

    @Override
    public List<Source> findSourcesBySearchString(String searchString) {
        return this.sources.stream()
                .filter(source -> source.getSourceName().contains(searchString))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Source> findSourceById(String id) {
        return this.sources.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }

    @Override
    public String getUniquePluginId() {
        return this.pluginId;
    }
}
