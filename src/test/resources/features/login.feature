Feature: Login Functionality test using Data Driven

  Background: 
    Given User is on login page "https://practice.expandtesting.com/login"

  Scenario Outline: Test login functionality
    When User enters "<username>" and "<password>"
    And Click on Login or Submit button
    Then User should be logged in successfully

    Examples: 
      | username | password             |
      | practice | SuperSecretPassword! |
