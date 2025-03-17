Feature:View Room Details

  Scenario:View the Room Details of the selected check-in and check-out dates
    Given The user is on the Reservation page
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date
    Then A list of available rooms for the selected period should be displayed
    And The user views the Online-Preis section by clicking "Details anzeigen" link
    When The user clicks on the tablist and displays to verifies content sections
      | Beschreibung     |
      | Zusatzleistungen |
      | Fotos            |

    Then The user clicks on the link "Details ausblenden" to close all sections