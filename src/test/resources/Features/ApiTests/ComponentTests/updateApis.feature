@API
Feature: Fund Street all Update APIs Testing Automation

  Scenario Outline: Validate Update User Financial Details
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint                | JSON                        | StatusCode |
      | API_BASE_URL | UPDATE_FINANCIAL_DETAIL | updateFinencialDetails.json | 200        |