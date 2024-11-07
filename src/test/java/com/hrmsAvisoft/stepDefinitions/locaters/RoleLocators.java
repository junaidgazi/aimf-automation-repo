package com.hrmsAvisoft.stepDefinitions.locaters;

import org.openqa.selenium.By;

public class RoleLocators {
    public static final By EMAIL = By.id("Email");
    public static final By PASSWORD = By.id("Password");
    public static final By LOGIN_BUTTON = By.xpath("//*[text()='Login']");
    public static final By ROLE_MENU = By.xpath("//*[text()='Role']");
    public static final By NEW_ROLE_BUTTON = By.xpath("//*[text()='New Role']");
    public static final By ROLE_INPUT_FIELD = By.id("role");
    public static final By SELECT_ALL_PRIVILEGES = By.xpath("//*[text()='Select All Privileges']");
    public static final By CREATE_ROLE_BUTTON = By.cssSelector("button[type='submit'].bg-blue-700");
    public static final By NEW_ROLE_SECTION = By.xpath("//*[text()='New Role']");
    public static final By ROLE_LIST_SECTION = By.xpath("//*[text()='Role List']");
    public static final By HR_ASSISTANT_ROLE = By.xpath("//*[text()='HR Assistant']");
}
