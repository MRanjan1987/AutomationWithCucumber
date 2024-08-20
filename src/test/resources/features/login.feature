Feature: Login Functionality test using Data Driven

  Scenario Outline: Test login functionality
    Given User is on login page "https://practice.expandtesting.com/login"
    When User enters "<username>" and "<password>"
    And Click on Login or Submit button
    Then User should be logged in successfully

    Examples:
      | username | password |
      | practice | SuperSecretPassword!|
