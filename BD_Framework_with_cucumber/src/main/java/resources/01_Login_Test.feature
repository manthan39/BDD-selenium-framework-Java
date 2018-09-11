@smoke
Feature: Login Action

Scenario: Login with valid credentials
	Given User is on registration page
	When User enters valid registration details
	Then Message displayed registration Successfully


Scenario: Login with invalid credentials
	Given User is on registration page
	When User enters Invalid registration details
	Then Message displayed enter valid credentials