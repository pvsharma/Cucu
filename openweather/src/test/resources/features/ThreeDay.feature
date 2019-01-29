@ThreeDay
Feature: Click on one of the day should display three hours weather report

Scenario: Three hours weather report should be displayed if one of the date is clicked.
Given The user has navigated to the weather of city Perth
	When Clicked on the first date displyed for Perth
	Then Rows of weather forecast should be displayed with span for three hours
	And All the rows should have the same number of columns as overall weather.
