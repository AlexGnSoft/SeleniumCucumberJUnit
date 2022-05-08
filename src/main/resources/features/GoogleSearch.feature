Feature: Check google search functionality

  Scenario: Validate google search is working

    Given Browser is opened
    And User is on google search page
    When User enters a text in google search box
    And User hits enter button
    Then User is navigated to the Search Results page