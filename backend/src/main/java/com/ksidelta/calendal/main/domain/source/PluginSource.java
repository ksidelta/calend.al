package com.ksidelta.calendal.main.domain.source;

public class PluginSource {
    Source source;
    String pluginId;

    public PluginSource(Source source, String pluginId) {
        this.source = source;
        this.pluginId = pluginId;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }
}
