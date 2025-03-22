Feature: Change the dates

  Scenario: Change The Dates
    Given Navigate HotelCastle
    When Click on the date picker
    Then Select a check-in and check-out date
    #And change a check-in date
    #Then change a check-out date
    When The user selects a check-in date
    And The user selects a check-out date later than the check-in date


    Scenario: Change The Dates Negative
      Given Navigate HotelCastle
      When Click on the date picker
      Then Try to select a check-out date that is before the check-in date
