package com.hrmsAvisoft.stepDefinitions.api;

import com.hrmsAvisoft.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import static org.junit.Assert.assertEquals;

public class fundStreetApi {
    private String apiUrl = "";
    private String jwtToken;
    private String requestBody;
    private Response response;

    @Given("^User set api (.*).$")
    public void setApiUrls(String endpoint) {
        try {
            apiUrl = apiUrl + Config.getUrl(endpoint);
        } catch (Exception e) {
            Assert.fail("Error setting API endpoint: " + e.getMessage());
        }
    }

    @Given("User get Token from JwtToken.properties file")
    public void setUserToken() {
        try {
            jwtToken = Config.getJwtToken();
        } catch (Exception e) {
            Assert.fail("Error setting JWT token: " + e.getMessage());
        }
    }

    @And("^User read request body from (.*) file.$")
    public void sendRequestBody(String body) {
        String basePath = "src/test/resources/JsonResources/";
        String filePath = basePath + body;
        try {
            requestBody = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            Assert.fail("Error setting request body: " + e.getMessage());
        }
    }


    @When("^User sends a (.*) request.")
    public void sendRequest(String requestType) {
        try {
            // Start building the request
            RequestSpecification request = RestAssured.given()
                    .header("Authorization", "Bearer " + jwtToken)
                    .contentType("application/json");

            // Set the body for POST, PUT requests
            if (requestType.equalsIgnoreCase("POST") || requestType.equalsIgnoreCase("PUT")) {
                request.body(requestBody);
            }

            // Send the appropriate request based on request type
            switch (requestType.toUpperCase()) {
                case "GET":
                    response = request.get(apiUrl);
                    break;
                case "POST":
                    response = request.post(apiUrl);
                    break;
                case "PUT":
                    response = request.put(apiUrl);
                    break;
                case "DELETE":
                    response = request.delete(apiUrl);
                    break;
                default:
                    Assert.fail("Unsupported request type: " + requestType);
            }
        } catch (Exception e) {
            Assert.fail("Error sending " + requestType + " request: " + e.getMessage());
        }
    }


    @And("Now user set token and otp")
    public void setTokenRunTime() {
        try {
            if (response.getStatusCode() == 201) {
                JsonPath jsonPath = response.jsonPath();
                jwtToken = jsonPath.getString("data.token");
                String otp = jsonPath.getString("data.otp");
                System.out.println("Generated Token: " + jwtToken);
                System.out.println("Generated OTP: " + otp);

                // Create a JSON object to write OTP
                JSONObject otpJson = new JSONObject();
                otpJson.put("otp", otp);

                // Write the JSON object to a file
                try (FileWriter file = new FileWriter("src/test/resources/JsonResources/otp.json")) {
                    file.write(otpJson.toString());
                    file.flush();
                } catch (IOException e) {
                    Assert.fail("Error writing OTP to JSON file: " + e.getMessage());
                }
            } else {
                Assert.fail("Unexpected status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
            Assert.fail("Error setting token and OTP: " + e.getMessage());
        }
    }

    @And("User set otp in json file")
    public void setOtp() {
        if (response.getStatusCode() == 201) {
            JsonPath jsonPath = response.jsonPath();
            String otp = jsonPath.getString("data.otp");
            System.out.println("Generated OTP: " + otp);
            JSONObject otpJson = new JSONObject();
            otpJson.put("otp", otp);
            try (FileWriter file = new FileWriter("src/test/resources/JsonResources/otp.json")) {
                file.write(otpJson.toString());
                file.flush();
            } catch (IOException e) {
                Assert.fail("Error writing OTP to JSON file: " + e.getMessage());
            }
        }
    }

    @And("user set token in permanent place in token.json file")
    public void setTokenPermanently() {
        String token = response.jsonPath().getString("data.token");
        // Create a Properties object
        Properties properties = new Properties();
        properties.setProperty("JWT_TOKEN", token);

        // Write to token.properties
        try (FileOutputStream outputStream = new FileOutputStream("src/test/resources/configuration/JwtToken.properties")) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("the response status should be {int}")
    public void checkResponseStatusCode(int statusCode) {
        try {
            assertEquals("Expected status code does not match", statusCode, response.getStatusCode());
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + statusCode + ", but got: " + response.getStatusCode());
        }
    }

}
