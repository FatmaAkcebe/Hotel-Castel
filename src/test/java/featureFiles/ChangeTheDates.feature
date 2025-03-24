Feature: Change the dates

  Scenario: Change The Dates
    Given Navigate HotelCastle
    When select check-in and check out dates
    And user changes Check-in date
    And user changes Check-out date
    Then New rooms should come
