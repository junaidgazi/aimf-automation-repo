@API
Feature: Fund Street all Get API's Testing Automation

  Scenario Outline: Validate Get Personal Option
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    When User sends a GET request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint        | StatusCode |
      | API_BASE_URL | PERSONAL_OPTION | 200        |

  Scenario Outline: Validate Get Financial Options
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    When User sends a GET request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint          | StatusCode |
      | API_BASE_URL | FINANCIAL_OPTIONS | 200        |

#  Scenario Outline: Validate Run Command
#    Given User set api <BaseUrl>.
#    Given User set api <EndPoint>.
#    When User sends a GET request.
#    Then the response status should be <StatusCode>
#
#    Examples:
#      | BaseUrl      | EndPoint    | StatusCode |
#      | API_BASE_URL | RUN_COMMAND | 200        |

  Scenario Outline: Validate Get All Section
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    When User sends a GET request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint        | StatusCode |
      | API_BASE_URL | GET_ALL_SECTION | 200        |


  Scenario Outline: Validate Get Mutual Funds
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    When User sends a GET request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint     | StatusCode |
      | API_BASE_URL | MUTUAL_FUNDS | 200        |


#  Scenario Outline: Validate Get Section Wise Questions
#    Given User set api <BaseUrl>.
#    Given User set api <EndPoint>.
#    Given User get Token from JwtToken.properties file
#    And User read request body from <JSON> file.
#    When User sends a POST request.
#    Then the response status should be <StatusCode>
#
#    Examples:
#      | BaseUrl      | EndPoint              | JSON                     | StatusCode |
#      | API_BASE_URL | SECTION_WISE_QUESTION | sectionWiseQuestion.json | 200        |


  Scenario Outline: Validate Get Fund Families
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    When User sends a GET request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint      | StatusCode |
      | API_BASE_URL | FUND_FAMILIES | 200        |