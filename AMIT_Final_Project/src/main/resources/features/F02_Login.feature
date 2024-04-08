Feature:

  Scenario Outline:
    Given user go to login page
    When  user login with "valid" "test@example.com" and "P@ssw0rd"
    And   user press on login button
    Then  user login to the system successfully
    Examples:
      |  |  |