Feature: Elearninn Registration

  Scenario: To log in to elearning website
    Given To launch elearning  website
    When Click signUp
    Then Fill up the registration form
      | firstname       | Kuldeep          |
      | lastname        | Jadon1           |
      | email           | test43@gmail.com |
      | username        | jk43             |
      | Password        |              123 |
      | ConfirmPassword |              123 |
    And Verify "Your personal settings have been registered."
    And click on next button
    And Once on HomePage , click your username
    And Choose profile from Dropdown
    And Click on Messages
    And click on Compose Message
    And Enter the details shown on the page
    And Click on Send message
