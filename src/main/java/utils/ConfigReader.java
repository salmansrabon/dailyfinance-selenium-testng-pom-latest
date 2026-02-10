package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final ConfigReader instance = new ConfigReader();
    private final Properties prop;

    private ConfigReader() {
        prop = new Properties();
        try (InputStream fs = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (fs == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }
            prop.load(fs);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static ConfigReader getInstance() {
        return instance;
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}
