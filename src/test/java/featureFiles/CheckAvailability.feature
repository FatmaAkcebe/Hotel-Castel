Feature: Check Room Availability

  Scenario: User checks room availability
    Given The user is on the homepage
    When Click on the date picker
   # And Select a check-in and check-out date
    When The user select a check-in date
   # And The user selects a check-out date
   # And The user selects a number of guests
    And The user clicks the Check Availability button
   # Then A list of available rooms for the selected period should be displayed
