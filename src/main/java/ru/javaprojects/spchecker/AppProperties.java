package ru.javaprojects.spchecker;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AppProperties {
    private static final Properties props;

    static {
        props = new Properties();
        try (var reader = new InputStreamReader(AppProperties.class.getClassLoader().getResourceAsStream("app.properties"), UTF_8)) {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Property " + key + " not found");
        }
        return value;
    }
}
