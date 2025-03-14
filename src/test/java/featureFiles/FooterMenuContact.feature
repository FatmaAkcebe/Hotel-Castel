Feature: Footer interactions on the website

  Background:
    Given The user navigates to the Hotel Castle website
    And The user scrolls down the page
    And The user accepts the cookie banner

  Scenario Outline: Clicking on the footer menu items and verifying the expected results
    When The user clicks on the "<Link>" in the footer
    Then The "<Link>" should be clickable
    And The user should be redirected to the "<Expected Result>" page

    Examples:
      | Link                | Expected Result       |
      | Footer Phone Number |                       |
      | Email Address       |                       |
      | Impressum           | impressum             |
      | Datenschutz         | datenschutzerklaerung |

  Scenario: Clicking on the "Up Button"
    When The user clicks on the go up button
    Then The go up button should be clickable. The page should scroll smoothly back to the top