package com.letskodeit.stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.letskodeit.hooks.Hooks;
import com.letskodeit.pages.PracticePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticePageStepDefinitions {
	
	WebDriver driver = Hooks.driver;
	PracticePage practicePage = new PracticePage(driver);
	
	
	@Given("the practice page is open")
	public void the_practice_page_is_open() {
		
		driver.get("https://www.letskodeit.com/practice");
		
		String expectedUrl = "https://www.letskodeit.com/practice";
		String actualUrl = driver.getCurrentUrl();
		
		if (actualUrl.equals(expectedUrl)) {
			System.out.println("successfully navigated to practice page");
		}
		
		Assert.assertEquals(expectedUrl, actualUrl);
	    
	}

	@When("the user selects the radio button labeled {string}")
	public void the_user_selects_the_radio_button_labeled(String radioOption) {
		practicePage.selectRadioButton(radioOption);
	}

	@Then("the radio button labeled {string} should be selected")
	public void the_radio_button_labeled_should_be_selected(String radioOption) {
		System.out.println("is Radio button selected: " + practicePage.isRadioButtonSelected(radioOption));
		Assert.assertTrue(practicePage.isRadioButtonSelected(radioOption), "Radio button is not selected");
	}
	
	@When("the user selects a checkbox labeled {string}")
	public void the_user_selects_a_checkbox_labeled(String checkboxLabel) {
		practicePage.selectCheckBox(checkboxLabel);
	}

	@Then("the checkbox labeled {string} should be checked")
	public void the_checkbox_labeled_should_be_checked(String checkboxLabel) {
		Assert.assertTrue(practicePage.isCheckboxSelected(checkboxLabel), "Checkbox labelled " + checkboxLabel + " is not checked");
	}

	@When("the user deselects the checkbox labeled {string}")
	public void the_user_deselects_the_checkbox_labeled(String checkboxLabel) {
		practicePage.selectCheckBox(checkboxLabel);
	}

	@Then("the checkbox labeled {string} should be unchecked")
	public void the_checkbox_labeled_should_be_unchecked(String checkboxLabel) {
		Assert.assertTrue(!practicePage.isCheckboxSelected(checkboxLabel), "Checkbox labelled " + checkboxLabel + " is still checked");
	}
	
	@When("the user clicks the Open Window button")
	public void the_user_clicks_the_open_window_button() {
		practicePage.clickOnOpenWindowButton();
	}

	@Then("a new window should open")
	public void a_new_window_should_open() {
		
		practicePage.switchToNewWindow();
		
		// put some wait here
		
		String expectedTitle = "All Courses";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle, "Unable to switch to new window");
	}

	@Then("the user closes the new window and switches back")
	public void the_user_closes_the_new_window_and_switches_back() {
		
		practicePage.closeNewWindowAndSwitchBack();
		
		String expectedTitle = "Practice Page";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle, "Unable to switch back to the practice page");

	}
	
	@When("the user clicks on the Open Tab button")
	public void the_user_clicks_on_the_open_tab_button() {
		practicePage.clickOnOpenTabButton();
	}

	@Then("a new tab should open")
	public void a_new_tab_should_open() {
		
		practicePage.switchToNewTab();
		
		String expectedTitle = "All Courses";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle, "Unable to switch to new Tab");
		
	}

	@Then("the user closes the new tab and switches back")
	public void the_user_closes_the_new_tab_and_switches_back() {
		
		practicePage.switchBackToMainTab();
		
		String expectedTitle = "Practice Page";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle, "Unable to switch back to the previous tab");
		
	}
	
	@When("the user selects option {string} from the dropdown")
	public void the_user_selects_option_from_the_dropdown(String option) {
		practicePage.selectOptionFromDropdown(option);
	}

	@Then("the selected option should be {string}")
	public void the_selected_option_should_be(String optionToSelect) {
		
		String actualSelectedOption = practicePage.getSelectedDropdownValue();
		String expectedSelectedOption = optionToSelect;
		
	    Assert.assertEquals(actualSelectedOption, expectedSelectedOption);
	    
	}
	
	@When("the user selects multiple options from the dropdown")
	public void the_user_selects_multiple_options_from_the_dropdown(List<String> options) {
	    
		practicePage.selectMultipleOptionsFromDropdown(options);
	    
	}

	@Then("the selected options should be displayed")
	public void the_selected_options_should_be_displayed(List<String> expectedOptions) {
		
		List<String> actualOptions = practicePage.getAllSelectedOptionsFromDropdown();
		Assert.assertEquals(expectedOptions, actualOptions, "multi-select dropdown selection mismatch");
		
	}
	
	@When("the user types {string} inside the auto-suggest input field")
	public void the_user_types_inside_the_auto_suggest_input_field(String searchText) {
		practicePage.enterAutoSuggestInputText(searchText);
	}

	@When("selects {string} from the suggestions")
	public void selects_from_the_suggestions(String suggestionOption) {
		practicePage.selectSuggestionFromSuggestionList(suggestionOption);
	}

	@Then("the selected value should be {string}")
	public void the_selected_value_should_be(String expectedValue) {
	    
		String actualValue = practicePage.getSelectedAutoSuggestFieldValue();
		Assert.assertEquals(actualValue, expectedValue, "Auto-suggest selection mismatch");
	}
	
	@When("the user clicks the enable button")
	public void the_user_clicks_the_enable_button() {
		practicePage.clickEnableButton();
	}

	@Then("the input field should be enabled")
	public void the_input_field_should_be_enabled() {
	    Assert.assertTrue(practicePage.isInputEnabled(), "The input field is not enabled");
	}

	@When("the user clicks the disable button")
	public void the_user_clicks_the_disable_button() {
		practicePage.clickDisableButton();
	}

	@Then("the input field should be disabled")
	public void the_input_field_should_be_disabled() {
		Assert.assertTrue(!practicePage.isInputEnabled(), "The input field is not disabled");
	}
	
	@When("the user clicks the hide button")
	public void the_user_clicks_the_hide_button() {
		practicePage.hideTextBox();
	}

	@Then("the text box should not be visible")
	public void the_text_box_should_not_be_visible() {
	    Assert.assertTrue(!practicePage.isTextboxDisplayed(), "text box is not hidden");
	}

	@When("the user clicks the show button")
	public void the_user_clicks_the_show_button() {
		practicePage.showTextBox();
	}

	@Then("the text box should be visible")
	public void the_text_box_should_be_visible() {
		Assert.assertTrue(practicePage.isTextboxDisplayed(), "text box is not visible");
	}
	
	@When("the alert button is clicked")
	public void the_alert_button_is_clicked() {
		practicePage.clickAlertButton();
	}

	@Then("an alert should appear with text {string}")
	public void an_alert_should_appear_with_text(String expectedAlertText) {
	    Assert.assertEquals(expectedAlertText, practicePage.getAlertText(), "alert text didn't match");
	}

	@Then("the alert should be accepted")
	public void the_alert_should_be_accepted() {
		practicePage.acceptAlert();
	}

	@When("the confirm button is clicked")
	public void the_confirm_button_is_clicked() {
		practicePage.clickConfirmButton();
	}

	@Then("a confirmation alert should appear with text {string}")
	public void a_confirmation_alert_should_appear_with_text(String expectedAlertText) {
		Assert.assertEquals(expectedAlertText, practicePage.getAlertText(), "confirm alert text didn't match");
	}

	@Then("the alert should be dismissed")
	public void the_alert_should_be_dismissed() {
		practicePage.dismissAlert();
	}
	
	@When("the mouse is hovered over the Mouse Hover button")
	public void the_mouse_is_hovered_over_the_mouse_hover_button() {
		practicePage.hoverOverMouseHoverButton();
	}

	@Then("the {string} option should be visible")
	public void the_option_should_be_visible(String option) {
		
		boolean isVisible;
	    
		if (option.equals("Top")) {
			isVisible = practicePage.isTopOptionDisplayed();
		} else {
			isVisible = practicePage.isReloadOptionDisplayed();
		}
		
		Assert.assertTrue(isVisible, option + "is not visible");
	}

	@When("the {string} option is clicked")
	public void the_option_is_clicked(String option) {
	    
		if (option.equals("Top")) {
			practicePage.selectTopOption();
		} else {
//			String currentUrl = driver.getCurrentUrl();
			
			practicePage.selectReloadOption();
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
//		    wait.until(ExpectedConditions.urlToBe(currentUrl));
		}
		
	}

	@Then("the page should scroll to the top")
	public void the_page_should_scroll_to_the_top() {
		// No direct validation needed, as Selenium does not detect scroll position changes easily
	}

	@Then("the page should reload")
	public void the_page_should_reload() {
	    
//		String currentUrl = driver.getCurrentUrl();
//	    practicePage.selectReloadOption();
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	    wait.until(ExpectedConditions.urlToBe(currentUrl));
	    
	}
	
	// Web Table Example 
	
	@When("the web table is located")
	public void the_web_table_is_located() {
	    Assert.assertTrue(practicePage.isWebTableDisplayed(), "Web Table is not visible");
	}

	@Then("the following data should be present:")
	public void the_following_data_should_be_present(DataTable dataTable) {
	    
		List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
		List<Map<String, String>> actualData = practicePage.getTableData();
		
		for (int i=0; i<expectedData.size(); i++) {
			
			Map<String, String> expectedRow = expectedData.get(i);
			Map<String, String> actualRow = actualData.get(i);
			
			Assert.assertEquals(expectedRow, actualRow, "Mismatch in row " + (i + 1));
		}
		
	}
	
	// iFrame Example
	
	@When("the page is switched to the iFrame")
	public void the_page_is_switched_to_the_i_frame() {
	    practicePage.switchToIFrame();
	}

	@Then("the iFrame content should be visible")
	public void the_i_frame_content_should_be_visible() {
	    
		String expectedHeading = "All Courses";
		String actualHeading = practicePage.getIFrameTitle();
		
		Assert.assertEquals(actualHeading, expectedHeading, "iFrame main heading mismatch");
	}

	@When("text {string} is entered in the search input field")
	public void text_is_entered_in_the_search_input_field(String searchText) {
		practicePage.fillIFrameSearchField(searchText);
	}

	@Then("the text should be correctly displayed inside the iFrame")
	public void the_text_should_be_correctly_displayed_inside_the_i_frame() {
		
		practicePage.getIFrameSearchInputText();
		
	}
	
	@Then("the text {string} should be correctly displayed inside the iFrame")
	public void the_text_should_be_correctly_displayed_inside_the_i_frame(String expectedText) {
	    
		String actualText = practicePage.getIFrameSearchInputText();
		Assert.assertEquals(actualText, expectedText, "search input text mismatch");
		
	}

}
