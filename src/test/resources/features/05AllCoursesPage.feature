@AllCoursesTests
Feature: All Courses Page
   Users should be able to filter courses by category and search for courses using the search field.
   
   Scenario: Filter courses by category
      Given the All Courses page is open
      When the category filter is set to "<category>"
      Then the URL should contain "<category-url>"
      
      Examples:
         | category        | category-url    |
         | Test Automation | test-automation |
         | Python          | python          |
         
    Scenario: Search for a course and verify results
       Given the All Courses page is open
       When "<searchText>" is entered in the search field
       Then all displayed course titles should contain "<searchText>"

       Examples:
          | searchText |
          | Sel        |