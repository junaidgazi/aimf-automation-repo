package com.hrmsAvisoft.stepDefinitions.baseClasses;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;

public class fundStreetBaseApi {
    protected static CloseableHttpClient httpClient;

    @Before(value = "@API")
    public void initialization(Scenario scenario) {
        System.out.println("Initializing API Tests...");
        Assert.assertTrue("Unable to initialize HttpClient", initializeHttpClient());
    }

    public boolean initializeHttpClient() {
        try {
            httpClient = HttpClients.createDefault();
            return httpClient != null;
        } catch (Exception e) {
            Assert.fail("Failed to instantiate HttpClient: " + e.getMessage());
            return false; // Return false if assertion fails
        }
    }

    @After(value = "@API")
    public void tearDown(Scenario scenario) {
        // Log scenario failure status
        System.out.println("Scenario Failed: " + (scenario.isFailed() ? scenario.getName() : "None"));
        System.out.println("Scenario Status: " + scenario.getStatus());
    }
}
