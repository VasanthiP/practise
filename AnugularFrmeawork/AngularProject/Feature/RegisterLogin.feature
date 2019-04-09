Feature: Register Login

  @Login
  Scenario Outline: Verify the user is able to create a new account
    Given User Navigate to the application
    When User click on "Register" button
    And User enter "<FirstName>","<LastName>","<UserName>","<Password>" and click on RegisterButton
    Then Verify  "Registration successful"
    When Uesr login with Registered Credentials "<UserName>","<Password>" and click on login button
    Then Verify Login is sucessful with "You're logged in with Angular 6" is displayed

    Examples: 
      | FirstName | LastName | UserName | Password |
      | Manoj1    | kumar1    | mano1     | sanjay1   |
