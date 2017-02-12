package net.oivind.java.HueCLI.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties props = new Properties();

    private void readProperties() throws IOException {
        String propertyFileName = "HueCLI.properties";

        props.load(getClass().getClassLoader().getResourceAsStream(propertyFileName));
    }

    public String getProperty(String key) throws IOException {
        if (props.isEmpty()) {
            readProperties();
        }
        return props.getProperty(key);
    }
}
