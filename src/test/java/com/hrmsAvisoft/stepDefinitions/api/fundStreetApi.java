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
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            String content = new String(Files.readAllBytes(Paths.get("src/test/resources/JsonResources/JwtToken.json")));
            JSONObject jsonObject = new JSONObject(content);
            jwtToken = jsonObject.getString("TOKEN");
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

    @And("User set otp in json file")
    public void setOtp() {
        if (response.getStatusCode() == 200) {
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

        // Create a JSONObject and put the token
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TOKEN", token);

        // Write the JSON object to token.json file
        try (FileWriter file = new FileWriter("src/test/resources/JsonResources/JwtToken.json")) {
            file.write(jsonObject.toString(4)); // Pretty-print the JSON with indentation level 4
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

    @And("User wait 10 seconds Because user can not sent multiple request at a time")
    public void userWait() throws InterruptedException {
        Thread.sleep(15000);
    }

}
