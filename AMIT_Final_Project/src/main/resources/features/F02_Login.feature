@smoke
Feature:
  Scenario Outline: user could login with valid email and password
    Given user go to login page
    When  user login with <Email> and <Password>
    And   user press on login button
    Then  user login to the system successfully
    Examples:
      |     Email      | Password |
      |test@example.com| P@ssw0rd |



  Scenario Outline: user could login with invalid email and password
    Given user go to login page
    When  user login using invalid <Email> and <Password>
    And   user press on login button
    Then  user could not login to the system
    Examples:
      |     Email      | Password |
      |wrong@example.com| P@ssw0rd |
