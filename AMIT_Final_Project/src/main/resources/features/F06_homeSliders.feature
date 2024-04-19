@smoke
Feature:
  Scenario Outline:
    Given Open HomePage to slider
    When Click on Slider Image <number>
    Examples:
      | number  |
      |    1    |
      |    2    |