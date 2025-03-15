Feature: Check if the hotel has directions

  Scenario: directions to the hotel
    Given Navigate to hootelCastle
    When Check the description of the hotel's location.
    Then Check the buttons on the map
    And Check the hotel's activity information

