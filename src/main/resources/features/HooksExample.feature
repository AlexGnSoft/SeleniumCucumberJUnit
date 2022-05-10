Feature: Check login functionality

  Scenario: Validate login

    Given User is on login page
    When User enters valid username and password
    And User clicks on Login button
    Then User is navigated to the home page
