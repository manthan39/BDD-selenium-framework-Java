@regression
Feature: Calculator test


Scenario: Addition of two input
	Given User is on Calculator page
	When User enter first input
	When User enter second input
	When User select symbol
	And User click on Go button
	Then User get correct result