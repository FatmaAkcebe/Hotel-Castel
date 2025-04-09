Feature: Comment Navigation

  Background:
    Given The user navigates to the Hotel Castle website

  @RegressionTest
  Scenario: Manual comment transition
    When The user scrolls down to make the comments section visible
    Then The comments should be visible
    When The user clicks on each comment point and the corresponding comment should be displayed