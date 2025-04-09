Feature: Reservation Info Check

  @SmokeTest
  Scenario: Selected room details should be correctly displayed on the information filling screen
    Given The user is on the Reservation page
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date
    Then A list of available rooms for the selected period should be displayed
    When The user selects a room from the available list
    And The user proceeds to the information filling screen
    Then The reservation details on the information filling screen should match the selected details