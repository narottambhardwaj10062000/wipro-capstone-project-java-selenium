@LoginTests
Feature: User Login
  Users should be able to log in with valid credentials and see appropriate messages for incorrect attempts.

  Scenario Outline: Login with valid credentials
    Given the login page is open
    When the username "<username>" and password "<password>" are entered
    And the login button is clicked
    Then the message "<result>" should be displayed

    Examples: 
      | username              | password   | result                                                      |
      | narottam220@gmail.com | Monkey@555 | Login Successful                                            |
      | narottam22@gmail.com  | India@1234 | Incorrect login details                                     |
      | narottam220@gmail.com | India      | Incorrect login details                                     |
      | narottam22@gmail.com  | India      | Incorrect login details                                     |
      |                       | India@1234 | The email field is required.                                |
      | narottam220@gmail.com |            | The password field is required.                             |
      |                       |            | The email field is required.The password field is required. |
