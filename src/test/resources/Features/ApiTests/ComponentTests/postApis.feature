@API
Feature: Fund Street all Post APIs Testing Automation

  Scenario Outline: Validate User Authentication Otp
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint           | JSON       | StatusCode |
      | API_BASE_URL | AUTHENTICATION_OTP | email.json | 202        |


  Scenario Outline: Validate Forget Password
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint        | JSON       | StatusCode |
      | API_BASE_URL | FORGET_PASSWORD | email.json | 202        |


  Scenario Outline: Validate Populate Data
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint      | JSON        | StatusCode |
      | API_BASE_URL | POPULATE_DATA | string.json | 200        |

  Scenario Outline: Validate Resend Otp
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint   | JSON       | StatusCode |
      | API_BASE_URL | RESEND_OTP | email.json | 202        |


  Scenario Outline: Validate Check Health
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint     | JSON        | StatusCode |
      | API_BASE_URL | HEALTH_CHECK | string.json | 200        |


  Scenario Outline: Validate Read Mutual Funds
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint         | JSON                 | StatusCode |
      | API_BASE_URL | READ_MUTUAL_FUND | readMutualFunds.json | 200        |


  Scenario Outline: Validate Read Fund Data
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint       | JSON              | StatusCode |
      | API_BASE_URL | READ_FUND_DATA | readFundData.json | 200        |

  Scenario Outline: Validate Read Historical Data By Fund Id
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint              | JSON                        | StatusCode |
      | API_BASE_URL | HISTORICAL_DATA_BY_ID | historicalDataByFundId.json | 200        |


#  Not Working some issue in backend
  Scenario Outline: Validate Read Historical Filter Mutual Funds
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    And User wants to add body in JSON Format
      """
      {
        "min_investment_range_start": <minRangeStart>,
        "min_investment_range_end": <minRangeEnd>,
        "fund_family": "<fundFamily>",
        "morningstar_rating": "<morningStarRating>",
        "page": <pageNumber>,
        "page_size": <pageSize>
      }
      """
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | endPoint                    | minRangeStart | minRangeEnd | fundFamily                             | morningStarRating | pageNumber | pageSize | StatusCode |
      | /api/v1/mutual-funds/filter | 0             | 0           | Axis Asset Management Company Limited  | 2                 | 1          | 10       | 200        |
      | /api/v1/mutual-funds/filter | 0             | 0           | Bajaj Finserv Asset Management Limited | 0                 | 1          | 10       | 200        |
      | /api/v1/mutual-funds/filter | 0             | 0           | Aditya Birla Sun Life AMC Ltd          | 0                 | 1          | 10       | 200        |

