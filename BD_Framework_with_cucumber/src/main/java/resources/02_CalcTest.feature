@regression
Feature: Calculator test


Scenario: Addition of two input
	Given User is on Calculator page
	And User enter first input as "20"
	And User enter second input as "40"
	And User select symbol as "+"
	When User click on Go button
	Then User get correct result
	
	
Scenario: Subtraction of two input
	
	And User enter first input as "60"
	And User enter second input as "30"
	And User select symbol as "-"
	When User click on Go button
	Then User get correct result
	
	
Scenario: Division of two input
	
	And User enter first input as "50"
	And User enter second input as "5"
	And User select symbol as "/"
	When User click on Go button
	Then User get correct result
	Then Close the Browser
	