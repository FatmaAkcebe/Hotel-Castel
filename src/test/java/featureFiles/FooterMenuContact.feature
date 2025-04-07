Feature: Footer interactions on the website

  Background:
    Given The user navigates to the Hotel Castle website
    And The user scrolls down the page
    And The user accepts the cookie banner

    @SmokeTest
  Scenario: Clicking on the footer menu items and verifying the expected results
    When The user clicks on the phone number button in the footer menu
    And The application selection screen should appear, listing apps that can make a call
    When The user clicks on the email address button in the footer menu
    When The user clicks on the Impressum button in the footer menu
    Then The user should be redirected to the Impressum page
    And The user navigates back to the homepage
    When The user clicks on the Datenschutz button in the footer menu
    Then The user should be redirected to the Datenschutz page
    And The user navigates back to the homepage
    When The user clicks on the go up button
    Then The go up button should be clickable. The page should scroll smoothly back to the top