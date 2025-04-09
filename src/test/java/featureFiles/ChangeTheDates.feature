Feature: Change the dates

  @RegressionTest @SmokeTest
  Scenario: Change The Dates
    Given Navigate HotelCastle
    When The user selects the check-in and check-out dates
    And The user selects the check-in date
    And The user selects the check-out date
    Then New rooms should be displayed

  Scenario: Change The Dates negative
    Given Navigate HotelCastle
    When The user selects the check-in and check-out dates
    And The user selects the check-in date
    And User selects wrong check-out date
    Then New rooms should not be displayed