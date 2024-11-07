package com.hrmsAvisoft;

import java.io.InputStream;
import java.util.Properties;

public class configLoader {
    private String baseUrl;
    private String apiBaseUrl;
    private String unassignedEmployeesDepartment;
    private String getAllPerformance;
    private String UnAssignedDepartment;
    private String UnAssignedBranches;
    private String MySqlPath;
    private String MySqlUserName;
    private String MySqlUserPassword;

    // Constructor that initializes the properties by calling loadProperties
    public configLoader() {
        loadProperties();
    }

    // Method to load properties from the properties files
    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream baseUrlInput = getClass().getClassLoader().getResourceAsStream("configuration/apiEndPoints.properties");
             InputStream endpointsInput = getClass().getClassLoader().getResourceAsStream("configuration/endpoints.properties")) {

            // Check if input streams are not null
            if (baseUrlInput == null || endpointsInput == null) {
                throw new RuntimeException("Unable to find properties files");
            }

            properties.load(baseUrlInput);
            properties.load(endpointsInput);

            // Retrieve and assign values to class variables
            baseUrl = properties.getProperty("baseUrl");
            unassignedEmployeesDepartment = properties.getProperty("unassignedEmployeesDepartment");
            getAllPerformance = properties.getProperty("getGetAllPerformance");
            UnAssignedDepartment= properties.getProperty("unAssignedDepartment");
            UnAssignedBranches=properties.getProperty("UnAssignedBranches");
            MySqlPath=properties.getProperty("MySqlPath");
            MySqlUserName=properties.getProperty("MySqlUserName");
            MySqlUserPassword=properties.getProperty("MySqlUserPassword");
            apiBaseUrl=properties.getProperty("API_BASE_URL");
        } catch (Exception ex) {
            // Handle exceptions related to loading properties
            throw new RuntimeException("Error loading configuration", ex);
        }
    }

    // Getter method to return the full URL for unassigned employees department
    public String getUnassignedEmployeesDepartmentUrl() {
        return baseUrl + unassignedEmployeesDepartment;
    }
    public String getAllPerformance(){
        return baseUrl+ getAllPerformance;
    }
    public String getUnAssignedDepartment(){
        return baseUrl+ UnAssignedDepartment;
    }
    public String getUnAssignedBranches(){
        return baseUrl+ UnAssignedBranches;
    }
    public String getMySqlPath(){
        return MySqlPath;
    }
    public String getMySqlUserName(){
        return MySqlUserName;
    }
    public String getMySqlUserPassword(){
        return MySqlUserPassword;
    }
    public String getApiBaseUrl(){return apiBaseUrl;}

}
