Feature: Display the Introduction Section on the Homepage

  @RegressionTest
  Scenario: Verify the introduction section is displayed correctly
    Given The user is on the homepage
    When The user scrolls down to the introduction section
    Then The Willkommen Beim field should be visible in the introduction section
    And The content of the Willkommen Beim field should contain the expected text
