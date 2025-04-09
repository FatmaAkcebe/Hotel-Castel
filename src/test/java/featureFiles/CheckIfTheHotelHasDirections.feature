Feature: Check if the hotel has directions

  @RegressionTest @SmokeTest
  Scenario: Directions to the hotel
    Given Navigate HotelCastle
    When The user checks the description of the hotel's location.
    Then The user checks the hotel's activity information