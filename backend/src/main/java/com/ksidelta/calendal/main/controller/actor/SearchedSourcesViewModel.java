package com.ksidelta.calendal.main.controller.actor;

import java.util.List;

public class SearchedSourcesViewModel {
    List<SourceElement> elements;

    public SearchedSourcesViewModel() {
    }

    public SearchedSourcesViewModel(List<SourceElement> elements) {
        this.elements = elements;
    }

    public List<SourceElement> getElements() {
        return elements;
    }

    public void setElements(List<SourceElement> elements) {
        this.elements = elements;
    }

    static class SourceElement {
        String id;
        String title;
        String uniquePluginId;

        public SourceElement() {
        }

        public SourceElement(String id, String title, String uniquePluginId) {
            this.id = id;
            this.title = title;
            this.uniquePluginId = uniquePluginId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUniquePluginId() {
            return uniquePluginId;
        }

        public void setUniquePluginId(String uniquePluginId) {
            this.uniquePluginId = uniquePluginId;
        }
    }
}

