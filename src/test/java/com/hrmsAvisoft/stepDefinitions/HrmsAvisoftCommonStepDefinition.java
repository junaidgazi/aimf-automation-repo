package com.hrmsAvisoft.stepDefinitions;

import com.hrmsAvisoft.PropertiesLoader;
import com.hrmsAvisoft.stepDefinitions.baseClasses.HrmsBaseUi;
import com.hrmsAvisoft.stepDefinitions.locaters.RoleLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;


public class HrmsAvisoftCommonStepDefinition {
    public static WebDriver driver = HrmsBaseUi.driver;
    private static final String propertyFilePath = "src/test/resources/Properties/hrmsAvisoftEndPoints.properties";
    PropertiesLoader propertiesLoader = new PropertiesLoader(propertyFilePath);

    @Given("^User navigates to the (.*).$")
    public void navigateToHomepage(String expectedUrl) {
        String urlToOpen;
        Map<String, String> urlMappings = new HashMap<>();
        urlMappings.put("HrmsAvisoft Home page", propertiesLoader.getBaseUrlProperty("BASE_URL"));
        try {
            // Get the URL from the map, or use the expected URL directly if not found
            urlToOpen = urlMappings.getOrDefault(expectedUrl, expectedUrl);
            driver.get(urlToOpen);
            System.out.println("Opened URL: " + urlToOpen);
        } catch (Exception e) {
            Assert.fail("Failed to navigate to the expected URL: " + e.getMessage());
        }
    }

    @Then("^User should be verify the Application title (.*).$")
    public void verifyApplicationTitle(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            assertEquals(actualTitle, expectedTitle);
            System.out.println("Actual title is: " + actualTitle + " and Expected title is: " + expectedTitle);
        } catch (Exception e) {
            Assert.fail("Failed to verify the application title. Expected: " + expectedTitle + ", Actual: " + driver.getTitle() + ". Error: " + e.getMessage());
        }
    }

    @And("^User enter credentials for login (.*) and (.*).$")
    public void enterLoginCredentials(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(RoleLocators.EMAIL));
            WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(RoleLocators.PASSWORD));
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            System.out.println("Entered email and password for login.");
        } catch (Exception e) {
            Assert.fail("Failed to enter login credentials. Error: " + e.getMessage());
        }
    }

    @And("User clicks on the Login button")
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(RoleLocators.LOGIN_BUTTON));
            loginButton.click();
            System.out.println("Clicked on the Login button.");
            Thread.sleep(3000);
        } catch (Exception e) {
            Assert.fail("Failed to click on the Login button. Error: " + e.getMessage());
        }
    }
}

