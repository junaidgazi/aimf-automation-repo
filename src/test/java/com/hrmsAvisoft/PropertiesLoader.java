package com.hrmsAvisoft;

import org.junit.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private Properties properties;

    public PropertiesLoader(String filePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            Assert.fail("Failed to property file load : " + e.getMessage());
        }
    }

    public String getBaseUrlProperty(String BASE_URL) {
        return properties.getProperty(BASE_URL);
    }

}
