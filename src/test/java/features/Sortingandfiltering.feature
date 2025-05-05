@recent_development
Feature: Sorting and filtering

  #Apply filters (Brand, Price, Rating, etc.)
  #Verify products are updated accordingly
  Scenario Outline: Sorting an product on mobile page
  
    Given User is on the HomePage
    When User clicks on Mobile page
    And  Sorts it down with "<Brand>"
    Then Click on a product and verify
    
     Examples: 
      | Brand  |
      | Apple  |
      | Samsung |
      | VIVO |
      | Oppo |