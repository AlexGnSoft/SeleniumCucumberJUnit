Feature: Test login functionality

 Scenario Outline: Check log in successful with valid credentials

    Given Browser is opened
    And User is on login page
    When User enters <username> and <password>
    And User clicks on Login button
    Then User is navigated to the home page

   Examples:
     | username | password |
     | Alex     | 12345    |
     | German   | 54321    |




