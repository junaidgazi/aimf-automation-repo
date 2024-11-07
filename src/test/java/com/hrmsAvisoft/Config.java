package com.hrmsAvisoft;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties apiProperties = new Properties();
    private static Properties tokenProperties = new Properties();

    static {
        loadApiProperties();
        loadTokenProperties();
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

    private static void loadTokenProperties() {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("configuration/JwtToken.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find token.properties");
            }
            tokenProperties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getUrl(String apiUrls) {
        return apiProperties.getProperty(apiUrls);
    }
//    public static String getApiEndpoint(String endpoint) {
//        return apiProperties.getProperty(endpoint);
//    }

    public static String getJwtToken() {
        return tokenProperties.getProperty("JWT_TOKEN");
    }

}
