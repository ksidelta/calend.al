package com.ksidelta.calendal.main.services.source;

import com.ksidelta.calendal.main.domain.source.PluginSource;

import java.util.List;
import java.util.Optional;

public interface SourceService {
    List<PluginSource> findSourcesBySearchString(String searchString);

    Optional<PluginSource> findSourceByIdAndPluginId(String pluginId, String id);
}
