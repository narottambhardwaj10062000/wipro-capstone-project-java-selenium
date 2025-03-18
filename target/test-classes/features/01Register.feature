@RegistrationTests
Feature: User Registration
  Users should be able to register with valid details and see appropriate messages for incorrect inputs.

  Scenario Outline: Register with different inputs
    Given the registration page is open
    When the user enters "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>"
    And the user solves the CAPTCHA manually
    And the register button is clicked
    Then the message "<result>" should be displayed on registration

    Examples: 
      | firstName | lastName | email               | password   | confirmPassword | result                                      |
      | Mani      | Kant     | manikant26@gmail.com | Monkey@555 | Monkey@555      | Registration successful                     |
      |           | Kant     | manikant3@gmail.com | Monkey@555 | Monkey@555      | Please fill out this field.                 |
      | Mani      |          | manikant27@gmail.com | Monkey@555 | Monkey@555      | Registration successful                     |
      | Mani      | Kant     | invalidEmail        | Monkey@555 | Monkey@555      | Please include an '@' in the email address  |
      | Mani      | Kant     | manikant3@gmail.com | Monkey@555 | Monkey@554      | Passwords do not match                      |
      | Mani      | Kant     | manikant3@gmail.com | short      | short           | The password must be at least 6 characters. |
