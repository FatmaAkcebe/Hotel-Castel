Feature: View Available Rooms with Details

  Scenario: Selecting a room and specifying booking details
    Given The user is on the Reservation page
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date
    Then A list of available rooms for the selected period should be displayed
    When The user specifies the number of adults for the booking
    And The user specifies the number of children if allowed for the selected room type
    And The user specifies the number of rooms to book
    Then The system should update the total price based on the number of rooms and guests selected
    