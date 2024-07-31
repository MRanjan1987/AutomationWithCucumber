Feature: Login

Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks on the login button
    Then the user should be redirected to the homepage
    And a welcome message should be displayed

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username and password
    And the user clicks on the login button
    Then an error message should be displayed
    And the user should remain on the login page

  Scenario: Unsuccessful login with empty username
    Given the user is on the login page
    When the user enters an empty username and a valid password
    And the user clicks on the login button
    Then an error message should be displayed
    And the user should remain on the login page

  Scenario: Unsuccessful login with empty password
    Given the user is on the login page
    When the user enters a valid username and an empty password
    And the user clicks on the login button
    Then an error message should be displayed
    And the user should remain on the login page

  Scenario: Unsuccessful login with empty username and password
    Given the user is on the login page
    When the user enters an empty username and an empty password
    And the user clicks on the login button
    Then an error message should be displayed
    And the user should remain on the login page

 


