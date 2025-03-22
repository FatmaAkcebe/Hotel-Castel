Feature:Currency Selection

  Scenario: Ensure that the selected currency from the drop-down menu is automatically activated
    Given The user is on to the Hotel Castle homepage
    When The user clicks the JETZT BUCHEN button
    Then The user is redirected to the JETZT BUCHEN booking page
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date
    Then A list of available rooms for the selected period should be displayed
    When The user displays the currency section located at the top-right corner of the booking page
    And The user clicks on the currency section and displays the opened dropdown menu
    Then The user displays each currency in the drop-down menu and checks whether it is active by clicking on it