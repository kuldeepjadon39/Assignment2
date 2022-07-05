Feature: demoQA Search

  Scenario Outline: To fill the demoQA form
    Given To launch demoQA website
    When Verify that firtname textbox is diplayed
    And enter first name in textbox "<Firstname>"
    And enter last name in textbox "<Lastname>"
    And enter email ID in textbox "<Email>"
    And enter mobile number in textbox"<MobileNumber>"
    And enter Subject in textbox "<Subject>"
    And enter current address in textbox"<Address>"
    Then click on submit button

    Examples: 
      | Firstname |  | Lastname |  | Email  |  | MobileNumber |  | Subject |  | Address |
      | Kuldeep   |  | Jadon    |  | a@.com |  |   1234567890 |  | Test    |  | abc     |
      | Ankit     |  | Sharma   |  | b@.com |  |   0987654321 |  | Test1   |  | xyz     |
      | Rahul     |  | Sonar    |  | c@.com |  |   0987612345 |  | Test 2  |  | poq     |
