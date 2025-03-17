Feature: View Customers Feedback

  Scenario: Display and store customer reviews
    Given The user is on the customer reviews page
    When The system loads and displays reviews with star ratings
    Then Reviews must be legible, well-formatted, and accessible
    And The database must store and update reviews properly
    And The user must be able to evaluate feedback easily