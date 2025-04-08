Feature: User should be able to view about its structure.

  @RegressionTest @SmokeTest
  Scenario: Check the about page
    Given Navigate HotelCastle
    When The user clicks on the About Us link from the menu
    And The user clicks on the change buttons
    Then The about us section should be visible