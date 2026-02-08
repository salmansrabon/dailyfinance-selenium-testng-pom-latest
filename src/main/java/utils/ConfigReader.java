package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop=new Properties();
    public ConfigReader() throws IOException {
//        FileInputStream fs=new FileInputStream("./src/main/resources/config.properties");
        prop=new Properties();
        InputStream fs = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties");
        prop.load(fs);
    }
    public static String get(String key) {
        return prop.getProperty(key);
    }
}
