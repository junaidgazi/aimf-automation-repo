@UI
Feature: HRMS Avisoft Application Homepage Automation

  Scenario Outline: User opens the homepage
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And  User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    Examples:
      | Email              | Password    |
      | Avinash@avisoft.io | Avi$oft1234 |