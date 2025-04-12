
Feature: Search Funtionality on Amazon

  Scenario: Search for an item
   Given User is on the HomePage
   When  User clicks and searches for an item
   And   User navigates to the results window
   Then  User applies different filters and narrows down the search 
   
   
  Scenario: Blank Search
   Given User is on the HomePage
   When  User clicks on Searchbutton
   But User stays in the same page
   

  Scenario: Search for an non existent item
   Given User is on the HomePage
   When  User searches for an non existent item
   Then Checks the auto correction happening and user selects the non existent item instead 
   And User sees no results found page
   
  Scenario: Search for an item and validates auto suggestion as you type
   Given User is on the HomePage
   When  User enters letters in the search box
   And  User checks auto completion results from the drop-down 
   Then User clicks on the sixth auto completed result from the drop-down
   
