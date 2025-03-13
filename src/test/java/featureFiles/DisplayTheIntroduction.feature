Feature: Display the Introduction Section on the Homepage

  Scenario: Verify the introduction section is displayed correctly
    Given The user is on the homepage
    When The user scroll down to the introduction section
    Then The user should see the "Willkommen Beim Castle Hotel Rastatt" field
    And The content of the "Willkommen Beim Castle Hotel Rastatt" field should contain the expected text
