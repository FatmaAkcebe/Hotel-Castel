Feature: Header Menu Control

  Background:
    Given The user navigates to the Hotel Castle website

  Scenario: Clicking on the header menu items and verifying the expected results
    When The user clicks on the Hotel Logo button in the header menu
    Then The user should be redirected to the Start page
    When The user clicks on the Start button in the header menu
    Then The user should be redirected to the Start page
    When The user clicks on the Über uns button in the header menu
    Then The user should be redirected to the Über uns page
    When The user clicks on the Anfahrt button in the header menu
    Then The user should be redirected to the Anfahrt page
    When The user clicks on the Aktivitäten button in the header menu
    Then The user should be redirected to the Aktivitäten page
    When The user clicks on the phone number in the header menu
    And The application selection screen should appear, listing apps that can make a call