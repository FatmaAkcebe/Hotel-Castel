Feature: Hotel Castle Booking System

  @RegressionTest @SmokeTest
  Scenario: Booking button redirects to the booking page
    Given The user is on the homepage
    When The user clicks the JETZT BUCHEN button
    Then The user is redirected to the JETZT BUCHEN booking page and verifies