Feature: Check Available Rooms by Date

  @RegressionTest @SmokeTest
  Scenario: Selecting valid check-in and check-out dates to display available rooms
    Given The user is on the Reservation page
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date
    Then A list of available rooms for the selected period should be displayed
    And Each room should display its type
    And Each room should display its price per night