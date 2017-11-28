@regression
Feature: Calculator test


Scenario: Addition of two input
	Given User is on Calculator page
	When User enter first input
	When user enter second input
	When user select symbol
	And user click on Go button
	Then User get correct result