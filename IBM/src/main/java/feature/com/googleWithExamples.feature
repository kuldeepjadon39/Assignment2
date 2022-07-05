@Functional
Feature: Google Search

  Scenario Outline: To type text in search bar
    Given To launch google website
    When The search bar is visible
    Then Enter the text "<Your Text>"

    Examples: 
      | Your Text |
      | IBM       |
      | KJ        |
      | Jigsaw    |
