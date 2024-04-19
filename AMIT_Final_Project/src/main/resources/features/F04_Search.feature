@smoke
Feature:
  Scenario Outline: user could search using product name
    Given Open HomePage
    When search using <product name>
    Then Search shows relevant results <product name>
    Examples:
      | product name |
      |     book     |
      |     laptop   |
      |     nike     |



  Scenario Outline: user could search for product using sku
    Given Open HomePage
    When search using <SKU>
    And Click On the product
    Then Search shows relevant SKU results <SKU>
    Examples:
      |     SKU      |
      |   SCI_FAITH  |
      |   APPLE_CAM  |
      |   SF_PRO_11  |