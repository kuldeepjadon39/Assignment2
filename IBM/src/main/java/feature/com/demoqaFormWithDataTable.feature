Feature: demoQA Search

  Scenario: To fill the demoQA form
    Given To launch demoQA website
    When Verify that firtname textbox is diplayed
    Then Fill Up the form
      | firstname | Kuldeep |
      | lastname  | Jadon   |
