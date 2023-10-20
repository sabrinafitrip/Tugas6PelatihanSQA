Feature: Login

  @Regression @Positive
  Scenario Outline: user can login with username and password registered
    Given user open the app
    When user input registered username
    And user input registered password
    And user tap login button
    Then user in page dashboard

    @Regression @Negative
  Scenario: user can login with username and password unregistered
    Given user open the app
    When user input unregistered username
    And user input unregistered password
    And user tap login button
    Then user get error message

