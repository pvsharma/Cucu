@City
Feature: To check the weather of a particular city

Scenario: Enter the city and get the weather.
Given I launch the weather page
  When I give the city
  Then I should see the weather forecast for 5 days
  And Each day should have 5 parameters