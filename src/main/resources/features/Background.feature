Feature: Check home page functionality

  Background: User is logged in
    Given User is on login page
    When User enters valid username and password
    And User clicks on Login button
    Then User in navigated to the home page

  Scenario: Check logout link
    When User clicks on welcome link
    Then Logout link is displayed

  Scenario: Verify quick launch toolbar is present
    When User clicks on dashboard link
    Then quick launch toolbar is displayed
