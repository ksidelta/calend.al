package com.ksidelta.calendal.main.services.source;

import com.ksidelta.calendal.main.domain.source.PluginSource;
import com.ksidelta.calendal.main.services.plugin.EventsPlugin;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SourceServiceImpl implements SourceService {
    List<EventsPlugin> eventsPlugins;

    public SourceServiceImpl(List<EventsPlugin> eventsPlugins) {
        this.eventsPlugins = eventsPlugins;
    }

    @Override
    public List<PluginSource> findSourcesBySearchString(String searchString) {
        return this.eventsPlugins.stream()
                .map(x -> Pair.of(x.getUniquePluginId(), x.findSourcesBySearchString(searchString)))
                .flatMap(pair -> pair.getSecond().stream().map(source -> new PluginSource(source, pair.getFirst())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PluginSource> findSourceByIdAndPluginId(String pluginId, String id) {
        return eventsPlugins.stream().map(plugin -> Pair.of(plugin.getUniquePluginId(), plugin.findSourceById(id)))
                .map(pair -> pair.getSecond().map(x -> new PluginSource(x, pair.getFirst())))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
