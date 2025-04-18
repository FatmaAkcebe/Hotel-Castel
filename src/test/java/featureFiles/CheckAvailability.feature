Feature: Check Room Availability

  @RegressionTest
  Scenario: User checks room availability
    Given The user is on the homepage
    When The user scrolls down to make the date picker visible
    And The user clicks on the date picker and the date picker opens
    And Select a check-in and check-out date
    And The user selects a number of guests
    When The user clicks the Check Availability button