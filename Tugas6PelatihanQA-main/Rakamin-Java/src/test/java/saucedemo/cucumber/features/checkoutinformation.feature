Feature: Checkout Information

  @Regression @Positive
  Scenario Outline: user can continue checkout if inputed personal data information
    Given  user tap icon cart
    When user tap checkout button
    And user input personal data information
    And user tap continue button
    Then user in next page

