Feature: Login Action

Scenario Outline: Successful Login with Valid Information
	Given User is on Main Page
	When User navigates to Login Page
	And User enters "<username>" and "<password>"
	Then Username displayed Successfully
	
	Examples:
		| username  | password |
		| The Boss  | wowz3r5  |
		| Doctor      | wowz3r5  |
		| Paramedic   | wowz3r5  |