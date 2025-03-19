Feature: Check the Accuracy of Hotel Information

  Scenario: Ensure that hotel information updates are displayed correctly
    Given The user is on to the Hotel Castle homepage
    When The user clicks the JETZT BUCHEN button
    Then The user is redirected to the JETZT BUCHEN booking page
    And The user checks the hotel information in the Informationen zur Anlage section