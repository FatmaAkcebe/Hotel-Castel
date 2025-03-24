Feature: Change the dates

  Scenario: Change The Dates
    Given Navigate HotelCastle
    When select check-in and check out dates
    And User selects check-in date
    And User selects check-out date
    Then New rooms should come

  Scenario: Change The Dates negative
    Given Navigate HotelCastle
    When select check-in and check out dates
    And User selects check-in date
    And User selects wrong check-out date
    Then New rooms not should come