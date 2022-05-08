#Author: Aleksandr Gnuskin
# Date: 07.03.2021
# Description: Authorization

Feature: feature to test login functionality

  @ValidCredentials
  Scenario: Check login is successful with valid credentials

    Given User is on login page
    When User enters username and password
    And User clicks on login button
    Then User is navigated to the home page
