package com.hrmsAvisoft;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties apiProperties = new Properties();

    static {
        loadApiProperties();
    }

    private static void loadApiProperties() {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("configuration/apiEndPoints.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find apiEndPoints.properties");
            }
            apiProperties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getUrl(String apiUrls) {
        return apiProperties.getProperty(apiUrls);
    }
}
