Feature: Check if the hotel has directions

  Scenario: Directions to the hotel
    Given Navigate HotelCastle
    When The user Check the description of the hotel's location.
    Then The user Check the hotel's activity information