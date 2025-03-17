Feature: Header Menu Control

  Background:
    Given The user navigates to the Hotel Castle website

  Scenario Outline: Clicking on the header menu items and verifying the expected results
    When The user clicks on "<Menu Item>" in the header menu
    Then The header menu should be visible
    And The user should be redirected to the "<Expected Result>" page

    Examples:
      | Menu Item   | Expected Result |
      | Logo        |                 |
      | Start       |                 |
      | Über Uns    | ueber-uns       |
      | Anfahrt     | anfahrt         |
      | Aktivitäten | aktivitaeten    |
