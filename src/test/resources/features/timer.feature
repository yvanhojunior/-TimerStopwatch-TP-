Feature: Timer basic behaviour

  Scenario: Timer starts in IdleTimer with default values
    Given the timer context is initialised
    Then the timer mode is "timer"
    And the timer state is IdleTimer
    And the timer value is 0
    And the mem timer value is 0