Feature: Create new Request Action

Scenario: Can create a new Expense Request
	Given User is on Main Page
	And User logs in
	And User clicks on 'Add a new Expense Request'
	Then User can enter Information into Input Fields
	When User clicks 'Submit your Request'
	Then A new Expense Request will be made