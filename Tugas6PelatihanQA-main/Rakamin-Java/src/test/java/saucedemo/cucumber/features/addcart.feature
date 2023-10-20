Feature: Add Cart

  @Regression @Positive
  Scenario Outline: user can checkout according to the selected product in the cart
    Given user login the app
    When user add product to cart
    And user tap icon cart
    And user tap checkout button
    Then user in next page

