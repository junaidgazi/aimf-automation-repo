@API
Feature: Fund Street Sign Up and Login API Testing

#  Scenario Outline: Validate successful User Authentication
#    Given User set api <BaseUrl>.
#    Given User set api <EndPoint>.
#    And User read request body from <JSON> file.
#    When User sends a POST request.
#    And user set token in permanent place in token.json file
#    And User set otp in json file
#    Then the response status should be <StatusCode>
#
#    Examples:
#      | BaseUrl      | EndPoint            | JSON        | StatusCode |
#      | API_BASE_URL | USER_AUTHENTICATION | signUp.json | 200        |

#  Scenario Outline: Validate successful otp password
#    Given User set api <BaseUrl>.
#    Given User set api <EndPoint>.
#    Given User get Token from JwtToken.properties file
#    And User read request body from <JSON> file.
#    When User sends a POST request.
#    And user set token in permanent place in token.json file
#    Then the response status should be <StatusCode>
#
#    Examples:
#      | BaseUrl      | EndPoint     | JSON     | StatusCode |
#      | API_BASE_URL | OTP_ENDPOINT | otp.json | 201        |

  Scenario Outline: Validate successful User Login
    Given User set api <BaseUrl>.
    Given User set api <EndPoint>.
    Given User get Token from JwtToken.properties file
    And User read request body from <JSON> file.
    When User sends a POST request.
    Then the response status should be <StatusCode>

    Examples:
      | BaseUrl      | EndPoint            | JSON        | StatusCode |
      | API_BASE_URL | USER_AUTHENTICATION | signUp.json | 200        |


#  Scenario Outline: Validate successful Change Password
#    Given User set api <BaseUrl>.
#    Given User set api <EndPoint>.
#    Given User get Token from JwtToken.properties file
#    And User read request body from <JSON> file.
#    When User sends a POST request.
#    Then the response status should be <StatusCode>
#
#    Examples:
#      | BaseUrl      | EndPoint        | JSON                | StatusCode |
#      | API_BASE_URL | CHANGE_PASSWORD | changePassword.json | 200        |



