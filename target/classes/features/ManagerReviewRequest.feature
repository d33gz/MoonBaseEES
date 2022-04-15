Feature: Request Review Action

Scenario Outline: Can Approve or Deny Pending Requests
	Given User is on Main Page
	And User is Logged in
	And User clicks on a Pending Request
	Then User can "<approve/deny>" Request
	When User clicks Commit
	Then Request will be updated.
	
	Examples:
		| approve/deny |
		| approve      |
		| deny         |
