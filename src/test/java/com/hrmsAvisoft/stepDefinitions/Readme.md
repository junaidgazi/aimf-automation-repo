HrmsAvisoftCommonStepDefinition file contains a Cucumber step definition class for automating tests of the HrmsAvisoft application. Here's a breakdown of its main purposes
1. WebDriver Initialization: It uses a WebDriver instance (from the HrmsBaseUi class) to interact with the web application.
2. Base URL Configuration: The baseUrl is loaded from a properties file, allowing the application to point to the correct URL dynamically.
3. Step Definitions: It defines several Cucumber steps that describe user interactions with the application:
    - Open Home Page: Navigates to the HrmsAvisoft home page.
    - Verify Page Title: Checks if the actual title of the web page matches the expected title.
    - Enter Login Credentials: Inputs user credentials (email and password) into the respective fields and clicks the login button.
4. Assertions: It uses assertions (via JUnit) to verify that the title matches expectations, ensuring that the application is functioning correctly.
5. Synchronization: The use of WebDriverWait helps manage timing issues, ensuring that elements are ready for interaction before actions are attempted.


=>superAdminPanel/CustomRolePrivileges file defines step definitions for testing features related to custom roles and privileges in the HrmsAvisoft application, specifically within the Super Admin Panel context. Here’s a breakdown of its purposes:
1. Step Definitions: It provides specific Cucumber steps that correspond to user interactions with the sidebar menu and role management features:
    - Check Role Visibility: Verifies that a specified role (e.g., "Role") is visible in the sidebar menu.
    - Click Sidebar Section: Simulates clicking on the sidebar menu section corresponding to roles.
    - Check Subrole Visibility: Confirms that a specific subrole (e.g., "New Role") is visible after interacting with the sidebar.
2. Element Interactions: It uses Selenium WebDriver to locate and interact with web elements by their text content, ensuring that specific roles and subroles are accessible within the UI.
3. Assertions: The class employs assertions (via JUnit and Assert) to check that the expected text matches the actual text found in the UI, thus validating the presence of UI elements.
4. Logging: It includes console output to indicate the success of operations, aiding in debugging and providing feedback during test execution.

=> baseClassess/HrmsBaseUi file serves as the base class for setting up and tearing down the Selenium WebDriver environment in the HrmsAvisoft automated testing framework. Here are its main purposes:
1. Test Initialization:
    - The @Before method initializes the testing environment before each scenario runs. It prints a message indicating the start of UI tests and checks if the environment is set up and the Chrome driver is instantiated successfully.
2. Environment Setup:
   - The setEnvironment() method determines the operating system and sets the appropriate path for the ChromeDriver executable based on whether the system is macOS, Linux, or Windows. This ensures compatibility across different platforms.
3. Driver Instantiation:
   - The instantiateChromeDriver() method configures and creates a new instance of the ChromeDriver. It sets options for Chrome (like disabling the sandbox and handling shared memory) and maximizes the browser window. It also sets an implicit wait time for finding elements, improving test stability.
4. Test Cleanup:
   - The @After method cleans up after each scenario. It quits the WebDriver instance if it is still running, ensuring that browser sessions are closed and resources are released. It also logs the status of the scenario (whether it passed or failed).

=> api/checkPerformanceEmployee The primary purpose of this Java class, checkPerformanceEmployee, is to facilitate API testing using the Cucumber framework and REST-assured library. Here’s a breakdown of its main functionalities:
1. API Response Configuration:
   - The @Given method (configureResponse) makes an HTTP GET request to various API endpoints based on the provided input. It checks if the API response status matches the expected status code and logs any failures.
2. JSON Response Comparison: 
   - The @Then method (compareJsonResponseWithExpectedJsonFile) compares the actual JSON response received from the API with expected JSON data stored in specified files. It reads the expected JSON, parses both the actual and expected JSON, and asserts their equality. If there are discrepancies, it logs the error and fails the assertion.
3. Logging: 
   - Throughout the class, SLF4J is used for logging, which helps in tracking the flow of execution and capturing any errors during the API calls or JSON parsing.
4. Error Handling: 
   - The class includes error handling for various exceptions, including IO exceptions and JSON parsing exceptions, ensuring that any issues are logged and the test fails gracefully.
   

=> locators/RoleLocators
   - The main purpose of the RoleLocators class is to define and manage locators for various web elements in a web application, specifically for testing scenarios involving user roles. This class is structured for use with Selenium.