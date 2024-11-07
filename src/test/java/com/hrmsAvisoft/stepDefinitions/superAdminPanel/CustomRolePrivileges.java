//package com.hrmsAvisoft.stepDefinitions.superAdminPanel;
//
//import com.hrmsAvisoft.stepDefinitions.locaters.RoleLocators;
//import com.hrmsAvisoft.configLoader;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import java.sql.*;
//import static com.hrmsAvisoft.stepDefinitions.baseClasses.HrmsBaseUi.driver;
//import static org.junit.Assert.assertEquals;
//
//public class CustomRolePrivileges {
//    configLoader configLoader = new configLoader();
//
//    @Then("^(.*) should be visible in sidebar menu$")
//    public void checkSidebarRoleVisibility(String expectedRole) {
//        try {
//            WebElement actualRole = driver.findElement(RoleLocators.ROLE_MENU);
//            String actualText = actualRole.getText();
//            assertEquals(actualText, expectedRole);
//            System.out.println("Role Section Found Successfully...");
//        } catch (Exception e) {
//            Assert.fail("Failed to verify the role in sidebar menu: " + e.getMessage());
//        }
//    }
//
//    @And("User clicks on the section on the sidebar menu")
//    public void clickSidebarRoleSection() {
//        try {
//            WebElement sidebar = driver.findElement(RoleLocators.ROLE_MENU);
//            sidebar.click();
//            System.out.println("Clicked on Role section in sidebar successfully...");
//        } catch (Exception e) {
//            Assert.fail("Failed to click on the sidebar section: " + e.getMessage());
//        }
//    }
//
//    @And("user clicks on the New Role button")
//    public void clickNewRoleButton() {
//        try {
//            WebElement sidebar = driver.findElement(RoleLocators.NEW_ROLE_BUTTON);
//            sidebar.click();
//            System.out.println("Clicked on the New Role button successfully...");
//        } catch (Exception e) {
//            Assert.fail("Failed to click on the New Role button: " + e.getMessage());
//        }
//    }
//
//    @And("^User enters the (.*) in the role name input field.$")
//    public void enterRoleName(String roleName) {
//        try {
//            WebElement roleInput = driver.findElement(RoleLocators.ROLE_INPUT_FIELD);
//            roleInput.sendKeys(roleName);
//            System.out.println("Role name entered successfully: " + roleName);
//        } catch (Exception e) {
//            Assert.fail("Failed to enter the role name: " + e.getMessage());
//        }
//    }
//
//    @And("user selects the appropriate privileges for a custom role and clicks on the Create Role button")
//    public void selectPrivilegesAndCreateRole() {
//        try {
//            WebElement selectAllPrivileges = driver.findElement(RoleLocators.SELECT_ALL_PRIVILEGES);
//            selectAllPrivileges.click();
//            WebElement createRoleButton = driver.findElement(RoleLocators.CREATE_ROLE_BUTTON);
//            createRoleButton.click();
//            System.out.println("Clicked on Create Role button successfully.");
//        } catch (Exception e) {
//            Assert.fail("Failed to select privileges and click Create Role button: " + e.getMessage());
//        }
//    }
//
//    @And("^User click on (.*) and click on (.*)$")
//    public void clickMethod(String parentClick, String chieldClick){
//        try{
//            WebElement parentClickVariable = driver.findElement(By.xpath("//*[text()='" + parentClick + "']"));
//            parentClickVariable.click();
//            WebElement childClickVariable = driver.findElement(By.xpath("//*[text()='" + chieldClick + "']"));
//            childClickVariable.click();
//        }catch (Exception e){
//            Assert.fail("Failed to click button"+ e.getMessage());
//        }
//    }
//
//    @And("^User give an input (.*) in (.*)$")
//    public void inputFilledMethod(String inputFieldName, String fillInput){
//        try{
//            WebElement searchInputField = driver.findElement(By.id(inputFieldName));
//            searchInputField.sendKeys(fillInput);
//        }catch (Exception e){
//            Assert.fail("Failed to filled input data "+ e.getMessage());
//        }
//    }
//
//    @And("^click on Create (.*) new fields$")
//    public void clickToCreateNewField(String submitButton){
//        try{
//            WebElement searchSubmitButton = driver.findElement(By.xpath("//button[text()='" + submitButton + "']"));
//            searchSubmitButton.click();
//        }catch (Exception e){
//            Assert.fail("Failed to click on submit button "+ e.getMessage());
//        }
//    }
//
//    @And("^User select value (.*) from DropDown (.*)$")
//    public void selectValueDropDown(String value , String dropDownName){
//        try{
//            Select dropdown = new Select(driver.findElement(By.id(dropDownName)));
//            dropdown.selectByVisibleText(value);
//        }catch (Exception e){
//            Assert.fail("Failed to select value in dropdown section "+ e.getMessage());
//        }
//    }
//
//    @And("^User select Manager name (.*) from Checkbox$")
//    public void selectCheckbox(String managerName){
//        try{
//            WebElement MangerName=driver.findElement(By.id("employee_1"));
//            MangerName.click();
//        }catch (Exception e){
//            Assert.fail("Failed to check value in checkbox section "+ e.getMessage());
//        }
//    }
//
//    @Then("^(.*) should be visible or not.$")
//    public void verifySubRoleVisibility(String expectedSubRole) {
//        try {
//            WebElement actualSubRole = driver.findElement(RoleLocators.NEW_ROLE_SECTION);
//            String actualText = actualSubRole.getText();
//            assertEquals(actualText, expectedSubRole);
//            System.out.println("New Role Section Found Successfully...");
//        } catch (Exception e) {
//            Assert.fail("Failed to verify the visibility of the expected sub role: " + e.getMessage());
//        }
//    }
//
//    @And("^User wait (.*) seconds.$")
//    public void waitInMilliseconds(int Time){
//        try {
//            int timeInMillisecond= Time*1000;
//            Thread.sleep(timeInMillisecond);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Then("^(.*) Role List should be visible.$")
//    public void verifyRoleListVisibility(String expectedRoleList) {
//        try {
//            WebElement actualRoleList = driver.findElement(RoleLocators.ROLE_LIST_SECTION);
//            String actualText = actualRoleList.getText();
//            assertEquals(actualText, expectedRoleList);
//            System.out.println("Role List Section Found Successfully...");
//        } catch (Exception e) {
//            Assert.fail("Failed to verify the visibility of the expected role list: " + e.getMessage());
//        }
//    }
//
//    @Then("^checking (.*) should be visible.$")
//    public void verifyNewRoleVisibility(String expectedRole) {
//        try {
//            WebElement actualRole = driver.findElement(RoleLocators.HR_ASSISTANT_ROLE);
//            String actualText = actualRole.getText();
//            assertEquals(actualText, expectedRole);
//            System.out.println("HR Assistant Section Found Successfully...");
//        } catch (Exception e) {
//            Assert.fail("Failed to verify the visibility of the expected role: " + e.getMessage());
//        }
//    }
//
//    @Then("^User verify to data in (.*) and (.*) and value (.*)$")
//    public void verifyDatabase(String tableName, String columnName, String Value){
//        String url = configLoader.getMySqlPath();
//        String user = configLoader.getMySqlUserName();
//        String password = configLoader.getMySqlUserPassword();
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            System.out.println("Connected to the database!");
//            Statement statement = conn.createStatement();
//            String query = "SELECT * FROM "+ tableName +" WHERE "+ columnName +" = '"+Value+"'";
//            ResultSet resultSet = statement.executeQuery(query);
//            boolean foundValue = false;
//            while (resultSet.next()) {
//                String organizationName = resultSet.getString(columnName);
//                if (organizationName.equals(Value)) {
//                    foundValue = true;
//                    break;
//                }
//            }
//            if (!foundValue) {
//                throw new AssertionError("Expected value: " + Value + " not foundValue in the database for " + columnName);
//            }
//        } catch (SQLException e) {
//            Assert.fail("Failed to fetch value from the database : " + e.getMessage());
//        }
//    }
//}
