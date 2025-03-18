@PracticePageTests
Feature: Practice Page Automation
  The practice page should allow users to interact with various UI elements such as radio buttons, checkboxes, input fields etc

  	 Scenario: Select a radio button
  	    Given the practice page is open
  	    When the user selects the radio button labeled "<option>"
  	    Then the radio button labeled "<option>" should be selected
  	    Examples:
  	       | option |
  	       | BMW  |
  	       | Benz |
  	       | Honda |
  	       
  	 Scenario: Select and deselect checkboxes
  	 		Given the practice page is open
  	 		When the user selects a checkbox labeled "<checkbox>"
  	 		Then the checkbox labeled "<checkbox>" should be checked
  
  	 		When the user deselects the checkbox labeled "<checkbox>"
  	 		Then the checkbox labeled "<checkbox>" should be unchecked
  	 		Examples:
  	 				| checkbox |
  	 				| Bmw |
  	 				| Benz |
  	 				| Honda |
  
  	 	Scenario: opening a new window
  	 	   Given the practice page is open
  	 	   When the user clicks the Open Window button
  	 	   Then a new window should open
  	 	   And the user closes the new window and switches back
  
  
  	 	Scenario: Opening a new tab
  	 	   Given the practice page is open
  	 	   When the user clicks on the Open Tab button
  	 	   Then a new tab should open
  	 	   And the user closes the new tab and switches back
  
  
  	 	Scenario: Selecting an option from a dropdown
  	 	   Given the practice page is open
  	 	   When the user selects option "<option>" from the dropdown
  	 	   Then the selected option should be "<option>"
  	 	   Examples:
  	 	   		| option |
  	 	   		| BMW |
  	 	   		| Benz |
  	 	   		| Honda |
  
  		Scenario: Selecting multiple options from multi-select dropdown
  		   Given the practice page is open
  		   When the user selects multiple options from the dropdown
  		      | Apple |
  		      | Orange |
  		   Then the selected options should be displayed
  		      | Apple |
  		      | Orange |
  
  	 	Scenario: Searching using auto-suggest
  	 	   Given the practice page is open
  	 	   When the user types "<inputText>" inside the auto-suggest input field
  	 	   And selects "<suggestedOption>" from the suggestions
  	 	   Then the selected value should be "<suggestedOption>"
  	 	     Examples:
  	 	       | inputText | suggestedOption    |
  	 	       | se        | Selenium WebDriver |
  	 	       | ja        | Java               |
  
  	 	Scenario: Checking the enabled and disabled state of an input field
  	 	   Given the practice page is open
  	 	   When the user clicks the enable button
  	 	   Then the input field should be enabled
  
  	 	   When the user clicks the disable button
  	 	   Then the input field should be disabled
  
  	 	Scenario: Checking the visibility of a input field
  	 	   Given the practice page is open
  	 	   When the user clicks the hide button
  	 	   Then the text box should not be visible
  
  	 	   When the user clicks the show button
  	 	   Then the text box should be visible
  
  
  	 	Scenario: Handling JavaScript alerts and confirm dialogs
  	 	   Given the practice page is open
  
  	 	   When the alert button is clicked
  	 	   Then an alert should appear with text "Hello , share this practice page and share your knowledge"
  	 	   And the alert should be accepted
  
  	 	   When the confirm button is clicked
  	 	   Then a confirmation alert should appear with text "Hello , Are you sure you want to confirm?"
  	 	   And the alert should be dismissed
  
  
  	 	Scenario: Hovering over the Mouse Hover button reveals options
  	 	   Given the practice page is open
  
  	 	   When the mouse is hovered over the Mouse Hover button
  	 	   Then the "Top" option should be visible
  	 	   And the "Reload" option should be visible
  
  	 	   When the "Top" option is clicked
  	 	   Then the page should scroll to the top
  
  	 	   When the "Reload" option is clicked
  	 	   Then the page should reload
  
  Scenario: Retrieve and verify table data
    Given the practice page is open
    When the web table is located
    Then the following data should be present:
      | Author        | Course                          | Price |
      | Let's Kode It | Selenium WebDriver With Java    |    35 |
      | Let's Kode It | Python Programming Language     |    30 |
      | Let's Kode It | JavaScript Programming Language |    25 |
      
    Scenario: Interact with elements inside an iFrame
       Given the practice page is open
       When the page is switched to the iFrame
       Then the iFrame content should be visible
       When text "Hello-iFrame!" is entered in the search input field 
       Then the text "Hello-iFrame!" should be correctly displayed inside the iFrame
       
      
      
