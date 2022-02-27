package com.ksidelta.calendal.main.controller.actor;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchedSourcesViewModel that = (SearchedSourcesViewModel) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return "SearchedSourcesViewModel{" +
                "elements=" + elements +
                '}';
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SourceElement that = (SourceElement) o;
            return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(uniquePluginId, that.uniquePluginId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title, uniquePluginId);
        }

        @Override
        public String toString() {
            return "SourceElement{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", uniquePluginId='" + uniquePluginId + '\'' +
                    '}';
        }
    }
}

