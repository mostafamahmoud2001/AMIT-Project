@smoke
Feature:
  Scenario: 1
    Given Open Home Page to wishlist
    When Open mobile
    And Add to wishlist
    Then success message is displayed with green background


  Scenario: 2
    Given Open Home Page to wishlist
    When Open mobile
    And Add to wishlist
    Then open wishlist page