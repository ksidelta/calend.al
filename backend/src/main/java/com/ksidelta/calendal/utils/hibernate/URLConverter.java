package com.ksidelta.calendal.utils.hibernate;

import javax.persistence.AttributeConverter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConverter implements AttributeConverter<URL, String> {
    @Override
    public String convertToDatabaseColumn(URL attribute) {
        return attribute.toString();
    }

    @Override
    public URL convertToEntityAttribute(String dbData) {
        try {
            return new URL(dbData);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("No co ty ziomek");
        }
    }
}
