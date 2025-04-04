Feature:Hotel Room Total Check

  Scenario: Price Change Verification of the Hotel Room and Added Packages
    Given The user is on the Reservation page
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date
    Then A list of available rooms for the selected period should be displayed
    When The user selects a room from the available list
    And The user proceeds to the information filling screen
    Then The reservation details on the information filling screen should match the selected details
    And The user fills out the form with the contact information
    Then The user clicks on the confirmation button and verifies the confirmation message
    And The user checks if the total price updates correctly with added packages