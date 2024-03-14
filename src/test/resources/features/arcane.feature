Feature: Playing a Game

  Scenario: Play a simple game in 2 rooms
    Given I have a game with the following attributes:
      | number of rooms       | 2 |
      | number of adventurers | 1 |
      | number of knights     | 0 |
      | number of cowards     | 0 |
      | number of gluttons    | 0 |
      | number of creatures   | 1 |
      | number of demons      | 1 |
      | number of food items  | 1 |
    When I play the game
    Then I should be told that either all the adventurers or all of the creatures have died
    And the game should be over

  Scenario: Play a more complicated game given in directions
    Given I have a game with the following attributes:
      | number of rooms       | 7 |
      | number of adventurers | 3 |
      | number of knights     | 3 |
      | number of cowards     | 3 |
      | number of gluttons    | 2 |
      | number of creatures   | 7 |
      | number of demons      | 4 |
      | number of food items  | 9 |
    When I play the game
    Then I should be told that either all the adventurers or all of the creatures have died
    And the game should be over
