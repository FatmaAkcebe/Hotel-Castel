Feature: Language Toggle Buttons

  Scenario: User switches the website language
    Given The user is on the homepage
    When The user clicks the language button Deutsch
    Then The website content should be displayed in the selected language
    And The language should remain active after page refresh
    When The user clicks the language button Englisch
    And The language should remain active after page refresh