Feature: Check Room Availability


  Scenario: User checks room availability
    Given I am on the hotel booking page
    When I select check-in date "2025-05-10"
    And I select check-out date "2025-05-15"
    And I select "2" guests
    And I click on "Check Availability" button
    Then I should see the available rooms
