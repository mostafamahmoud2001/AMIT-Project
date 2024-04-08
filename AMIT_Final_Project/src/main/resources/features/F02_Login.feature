Feature:

  Scenario Outline:
    Given user go to login page
    When  user login with "valid" <Email> and <Password>
    And   user press on login button
    Then  user login to the system successfully
    Examples:
      |     Email      | Password |
      |test@example.com| P@ssw0rd |