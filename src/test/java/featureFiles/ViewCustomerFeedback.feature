Feature: Comment Navigation
  Users should be able to navigate between comments either manually by clicking or automatically after a period of time.

  Background:
    Given The user navigates to the Hotel Castle website
    And The user scrolls down the page

  Scenario: Manual comment transition
    When The user scrolls down to make the comments section visible
    Then The comments should be visible
    When The user clicks on each comment dot
