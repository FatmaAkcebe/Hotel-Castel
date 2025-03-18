Feature: Change the dates

  Scenario: Change The Dates
    Given Navigate HotelCastle
    When Click on the date picker
    Then Select a check-in date

    Scenario: Change The Dates Negative
      Given Navigate HotelCastle
      When Click on the date picker
      Then Try to select a check-out date that is before the check-in date
