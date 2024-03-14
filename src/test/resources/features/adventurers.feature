Feature: Showing the capabilities of the Adventurers

  Scenario: The Adventurers' health can be updated
    Given an Adventurer with a health of 5
    When I add 2 to the health
    Then the Adventurer is still alive