Feature: View Customers Feedback

  Scenario: Display and store customer reviews
    Given the user is on the customer reviews page
    When the system loads and displays reviews with star ratings
    Then reviews must be legible, well-formatted, and accessible
    And the database must store and update reviews properly
    And users must be able to evaluate feedback easily