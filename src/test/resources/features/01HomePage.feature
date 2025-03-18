@HomePageTests
Feature: Home Page Verification
  The home page should display the correct title and all major sections.

  Scenario: Verify home page title and major sections
    Given the home page is open
    Then the title of the page should be "Home Page"
    And the following sections should be visible:
      | HOME        |
      | ALL COURSES |
      | INTERVIEW   |
      | SUPPORT     |
      | BLOG        |
