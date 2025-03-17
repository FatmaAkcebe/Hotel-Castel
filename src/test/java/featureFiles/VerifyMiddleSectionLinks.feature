Feature:Verify Navigation Links in the Middle Section

  Scenario: Check the navigation links in the middle section for proper redirection
    Given The user is on the homepage
    When The user scrolls down to the middle section
    Then The user should see the Anfahrt, Über uns and Aktivitäten sections
    When The user clicks on the Anfahrt link in the middle section
    Then The user should be redirected to the Anfahrt page
    When The user clicks on the Über uns link in the middle section
    Then The user should be redirected to the Über uns page
    When The user clicks on the Aktivitäten link in the middle section
    Then The user should be redirected to the Aktivitäten page
    And The user navigates back to the homepage