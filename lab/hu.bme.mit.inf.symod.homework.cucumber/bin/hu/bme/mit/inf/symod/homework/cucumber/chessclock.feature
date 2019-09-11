# Copyright 2019 © Andris Borbás™, All Rights ¯\_(00)_/¯®. <-- cp1252  >:(
Feature: Chess clock

  Scenario: Checking the START/RESET button in the game
    Given a fresh chess clock
    Then the MAIN display should display the text 'Ready to play'
    When I press the START button
    Then the MAIN display should display the text 'White moves'
    When I press the START button
    Then the MAIN display should display the text 'Ready to play'

  Scenario: White Timer, Lose and restart check
    Given a fresh chess clock
    When I press the START button
    And I wait for 1 s
    Then the MAIN display should display the text 'White moves'
    And the WHITE display should display the number 149
    And the BLACK display should display the number 150
    And NO BEEP should be made
    When I wait for 145 s
    Then the MAIN display should display the text 'White moves'
    And the WHITE display should display the number 4
    And the BLACK display should display the number 150
    And a BEEP should be made
    When I wait for 4 s
    Then the MAIN display should display the text 'White flag fallen'
    And the WHITE display should display the number 0
    And the BLACK display should display the number 150
    And a BEEP should be made
    When I press the START button
    Then the MAIN display should display the text 'Ready to play'

  Scenario: Black Timer, Lose and restart check
    Given a fresh chess clock
    When I press the START button
    And I press the WHITE button
    Then the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 160
    And the BLACK display should display the number 150
    And a BEEP should be made
    When I wait for 1 s
    Then the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 160
    And the BLACK display should display the number 149
    And NO BEEP should be made
    When I wait for 145 s
    Then the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 160
    And the BLACK display should display the number 4
    And a BEEP should be made
    When I wait for 4 s
    Then the MAIN display should display the text 'Black flag fallen'
    And the WHITE display should display the number 160
    And the BLACK display should display the number 0
    And a BEEP should be made
    When I press the START button
    Then the MAIN display should display the text 'Ready to play'

  Scenario: Increment
    Given a fresh chess clock
    When I press the START button
    And I wait for 1 s
    Then the MAIN display should display the text 'White moves'
    And the WHITE display should display the number 149
    And the BLACK display should display the number 150
    And NO BEEP should be made
    And I press the WHITE button
    Then the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 159
    And the BLACK display should display the number 150
    And a BEEP should be made
    When I wait for 2 s
    Then the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 159
    And the BLACK display should display the number 148
    And NO BEEP should be made
    When I press the BLACK button
    Then the MAIN display should display the text 'White moves'
    And the WHITE display should display the number 159
    And the BLACK display should display the number 158
    And a BEEP should be made

  Scenario: Increment set and overflow and also start timer setter for white
    Given a fresh chess clock
    When I press the MOD button
    Then a BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 150
    When I press the BLACK button
    Then NO BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 140
    When I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    Then NO BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 30
    When I press the BLACK button
    Then a BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 30
    When I press the START button
    Then NO BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 150
    When I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    Then NO BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 300
    When I press the WHITE button
    Then a BEEP should be made
    And the MAIN display should display the text 'White initial time'
    And the WHITE display should display the number 300
    When I press the MOD button
    And I press the MOD button
    Then a BEEP should be made
    And the MAIN display should display the text 'Increment time'
    And the WHITE display should display the number 10
    When I press the BLACK button
    Then NO BEEP should be made
    And the MAIN display should display the text 'Increment time'
    And the WHITE display should display the number 9
    When I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    And I press the BLACK button
    Then NO BEEP should be made
    And the MAIN display should display the text 'Increment time'
    And the WHITE display should display the number 0
    When I press the BLACK button
    Then a BEEP should be made
    And the MAIN display should display the text 'Increment time'
    And the WHITE display should display the number 0
    When I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    And I press the WHITE button
    Then NO BEEP should be made
    And the MAIN display should display the text 'Increment time'
    And the WHITE display should display the number 30
    When I press the WHITE button
    Then a BEEP should be made
    And the MAIN display should display the text 'Increment time'
    And the WHITE display should display the number 30
    When I press the MOD button
    And I press the MOD button
    And I press the START button
    And I press the WHITE button
    Then a BEEP should be made
    And the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 330
    When I press the BLACK button
    Then a BEEP should be made
    And the MAIN display should display the text 'White moves'
    And the BLACK display should display the number 180
    When I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    Then a BEEP should be made
    And the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 1170
    When I press the BLACK button
    And I press the WHITE button
    Then a BEEP should be made
    And the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 1200
    Then a BEEP should be made
    When I press the BLACK button
    And I press the WHITE button
    And the MAIN display should display the text 'Black moves'
    And the WHITE display should display the number 1200
    When I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    And I press the WHITE button
    And I press the BLACK button
    Then a BEEP should be made
    And the MAIN display should display the text 'White moves'
    And the BLACK display should display the number 1170
    When I press the WHITE button
    And I press the BLACK button
    Then a BEEP should be made
    And the MAIN display should display the text 'White moves'
    And the BLACK display should display the number 1200
    When I press the WHITE button
    And I press the BLACK button
    Then a BEEP should be made
    And the MAIN display should display the text 'White moves'
    And the BLACK display should display the number 1200

  Scenario: Beginner setter
    Given a fresh chess clock
    When I press the MOD button
    And I press the MOD button
    And I press the MOD button
    And I press the MOD button
    Then a BEEP should be made
    And the MAIN display should display the text 'White begins'
    When I press the WHITE button
    Then NO BEEP should be made
    And the MAIN display should display the text 'White begins'
    When I press the BLACK button
    Then NO BEEP should be made
    And the MAIN display should display the text 'BLACK begins'
    When I press the START button
    Then NO BEEP should be made
    And the MAIN display should display the text 'White begins'
