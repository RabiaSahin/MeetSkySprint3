Feature: As a user, I should be able to log out
  @MESK-317
  Scenario: 1-User can log out and ends up in log in page

  When Navigate to login page
    And Enter username into "Employee23" inputbox
    And Enter password into "Employee123" inputbox
    And Click on the login button on the login page
    Then Verify that user can login files page successfully
    And Click on the profile icon
    Then Verify that user can see the Logout link
    And Click on the Log out link
    Then Verify that user can log out on the files page and see login page

 @MESK-318
  Scenario: 2-User can not go to the home page again by clicking the step back button after successfully logging out

   When Navigate to login page
    And Enter username into "Employee23" inputbox
    And Enter password into "Employee123" inputbox
    And Click on the login button on the login page
    Then Verify that user can login files page successfully
    And Click on the profile icon
    Then Verify that user can see the Logout link
    And Click on the Log out link
    Then Verify that user can log out on the files page and see login page
    And Click on the step back button
    Then Verify that user can NOT go to home page again