Feature: As a user, I should be able to login.

  @MESK-266
  Scenario: 1- User can login with valid username and password
    When Navigate to login page
    And Enter username into "Employee23" inputbox
    And Enter password into "Employee123" inputbox
    And Click on the login button on the login page
    Then Verify that user can login files page successfully

  @MESK-274
  Scenario Outline: 2.1- User can not login with valid username and invalid password
    When Navigate to login page
    And Enter username into "<username>" inputbox
    And Enter password into "<password>" inputbox
    And Click on the login button on the login page
    Then Verify that user can not login and see the notice message

  Examples:
  | username   | password    |
  | Employee23 | Employee    |
  | Employee23 | Employeeabc |
  | Employee23 | Employee987 |

  @MESK-275
  Scenario Outline: 2.2- User can not login with invalid username and valid password
    When Navigate to login page
    And Enter username into "<username>" inputbox
    And Enter password into "<password>" inputbox
    And Click on the login button on the login page
    Then Verify that user can not login and see the notice message

  Examples:
   | username   | password    |
   | Employee   | Employee123 |
   | Employeeab | Employee123 |
   | Employee00 | Employee123 |

  @MESK-296
  Scenario: 2.3- User can not login with blank username and valid password
    When Navigate to login page
    And Enter username into "" inputbox
    And Enter password into "Employee123" inputbox
    And Click on the login button on the login page
    Then Verify that user can not login with blank username and see the alert message

  @MESK-297
  Scenario: 2.4- User can not login with valid username and blank password
    When Navigate to login page
    And Enter username into "Employee23" inputbox
    And Enter password into "" inputbox
    And Click on the login button on the login page
    Then Verify that user can not login with blank password and see the alert message

  @MESK-298
  Scenario: 3- User can see the password in a form of dots by default
    When Navigate to login page
    And Enter username into "Employee23" inputbox
    And Enter password into "Employee123" inputbox
    Then Verify that user can see the password in a form of dots by default

  @MESK-299
  Scenario: 4- User can see the password explicitly
    When Navigate to login page
    And Enter username into "Employee23" inputbox
    And Enter password into "Employee123" inputbox
    And Click on the eye sign after entering the password
    Then Verify that user can see the password explicitly

  @MESK-300
  Scenario: 5- User can see the "Forgot password?" link and the "Reset Password" button
    When Navigate to login page
    Then Verify that user can see the Forgot password? link
    And Click on the Forgot password? link
    Then Verify that user can see the Reset Password button

  @MESK-301
  Scenario: 6- User can see valid placeholders on Username and Password fields
    When Navigate to login page
    Then Verify that user can see valid placeholders on Username inpurbox
    Then Verify that user can see valid placeholders on Password inputbox

