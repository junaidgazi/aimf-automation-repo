package com.hrmsAvisoft.stepDefinitions.baseClasses;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class HrmsBaseUi {
    public static WebDriver driver;
    private static final int pageTimeOut = 10;

    @Before(value = "@UI")
    public void initialization(Scenario scenario) {
        System.out.println("Initializing UI Tests...");
        Assert.assertTrue("Unable to set environment", configureWebDriver());
        Assert.assertTrue("Unable to instantiate Chrome driver", initializeChromeDriver());
    }

    public boolean configureWebDriver() {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.startsWith("mac os x")) {
                System.setProperty("webdriver.chrome.driver", "src/lib/mac/chromedriver");
            } else if (osName.startsWith("linux")) {
                System.setProperty("webdriver.chrome.driver", "/path/to/linux/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/lib/win/chromedriver.exe");
            }
        } catch (Exception e) {
            Assert.fail("Failed to set up WebDriver environment: " + e.getMessage());
            return false; // Return false if assertion fails
        }
        return true;
    }

    public boolean initializeChromeDriver() {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(pageTimeOut, TimeUnit.SECONDS);
            return driver != null;
        } catch (Exception e) {
            Assert.fail("Failed to instantiate ChromeDriver: " + e.getMessage());
            return false; // Return false if assertion fails
        }
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {
        Optional.ofNullable(driver).ifPresent(WebDriver::quit);
        // Log scenario failure status
        System.out.println("Scenario Failed: " + (scenario.isFailed() ? scenario.getName() : "None"));
        System.out.println("Scenario Status: " + scenario.getStatus());
    }

}
