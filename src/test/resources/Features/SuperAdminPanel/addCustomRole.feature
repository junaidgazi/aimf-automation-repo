@UI
Feature: Custom role with a specific set of privileges

  Scenario Outline: Verify the visibility of role section
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And  User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    Then <Role section> should be visible in sidebar menu
    Examples:
      | Email              | Password    | Role section |
      | Avinash@avisoft.io | Avi$oft1234 | Role         |


  Scenario Outline: Verify the visibility of "New Role" page
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And  User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    And User clicks on the section on the sidebar menu
    Then <sub-section> should be visible or not.
    Examples:
      | Email              | Password       | sub-section  |
      | avinash@avisoft.io | Avi$oft1234    |  New Role    |


  Scenario Outline: Verify the visibility of Role list
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    And User clicks on the section on the sidebar menu
    Then <sub-section> Role List should be visible.
    Examples:
      | Email              | Password       | sub-section  |
      | avinash@avisoft.io | Avi$oft1234    |  Role List   |

  Scenario Outline: Verify the functionality of creating a new role
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    And User clicks on the section on the sidebar menu
    And user clicks on the New Role button
    And User enters the <Role Name> in the role name input field.
    And user selects the appropriate privileges for a custom role and clicks on the Create Role button
    Then User verify to data in <Table Name> and <Column Name> and value <Role Name>
    Examples:
      | Email              | Password       | Role Name       | Table Name | Column Name |
      | avinash@avisoft.io | Avi$oft1234    | Admin Assistant |    roles   |    role     |

  Scenario Outline: Create a new Organization
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And  User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    And User click on <Sidebar Menu> and click on <Create Fields>
    And User wait 2 seconds.
    And User give an input <Organization Name> in <Input Organization Name>
    And User wait 2 seconds.
    And User give an input <Organization Description> in <Input Description>
    And User wait 2 seconds.
    And click on Create <Submit Organization> new fields
    And User wait 2 seconds.
    Then User verify to data in <Table Name> and <Column Name> and value <Input Organization Name>
    Examples:
      | Email              | Password    | Sidebar Menu  | Create Fields       | Organization Name  | Input Organization Name | Organization Description  | Input Description                              | Submit Organization | Table Name   | Column Name       |
      | Avinash@avisoft.io | Avi$oft1234 | Organization  | Create Organization | organizationName   | AviSoftwares            | organizationDescription   | AviSoftware is a software development company  | Submit Organization | organization | organization_name |

  Scenario Outline: Create a new  Sub Organization
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And  User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    And User click on <Sidebar Menu> and click on <Create Fields>
    And User wait 2 seconds.
    And User select value <Value> from DropDown <DropdownName>
    And User wait 2 seconds.
    And User give an input <Sub Organization Name> in <Input Sub Organization>
    And User wait 2 seconds.
    And User give an input <Test Attributes> in <Input Test Attributes>
    And User wait 2 seconds.
    And click on Create <Button> new fields
    And User wait 2 seconds.
    Then User verify to data in <Table Name> and <Column Name> and value <Input Sub Organization>
    Examples:
      | Email              | Password    | Sidebar Menu      | Create Fields           | Value   | DropdownName | Sub Organization Name | Input Sub Organization  | Test Attributes  | Input Test Attributes                       | Button                  | Table Name   | Column Name  |
      | Avinash@avisoft.io | Avi$oft1234 | Sub Organization  | Create Sub Organization | Avisoft | organization | SubOrganization       | AviHTech                | test attribute   | AviHTech is a software development company  | Create Sub Organization | department   | department   |

  Scenario Outline: Create a new Department
    Given User navigates to the HrmsAvisoft Home page.
    Then User should be verify the Application title HRMS-Avisoft.
    And  User enter credentials for login <Email> and <Password>.
    And User clicks on the Login button
    And User click on <Sidebar Menu> and click on <Create Fields>
    And User wait 2 seconds.
    And User select value <Value> from DropDown <DropdownName>
    And User wait 2 seconds.
    And User give an input <Department Name> in <Input Department Name>
    And User wait 2 seconds.
    And User give an input <Department Description> in <Input Department Description>
    And User wait 2 seconds.
    And User give an input <Add Manager> in <Input Add Manager>
    And User wait 10 seconds.
    And User select Manager name <Input Add Manager> from Checkbox
    And User wait 2 seconds.
    And click on Create <Create Department Button> new fields
    And User wait 2 seconds.
    Then User verify to data in <Table Name> and <Column Name> and value <Input Department Name>
    Examples:
      | Email              | Password    | Sidebar Menu  | Create Fields  | Value   | DropdownName | Department Name | Input Department Name  | Department Description | Input Department Description                | Add Manager     | Input Add Manager  | Create Department Button  | Table Name | Column Name  |
      | Avinash@avisoft.io | Avi$oft1234 | Department    | New Department | Avisoft | organization | department      | AviHTech               | description            | AviHTech is a software development company  | employeeSearch  | Avinash Sharma     | Create Department         | department | department   |