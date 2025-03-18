package com.letskodeit.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letskodeit.basepage.BasePage;

public class PracticePage extends BasePage {

	private WebDriver driver;

	public PracticePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(id = "bmwradio")
	WebElement bmwRadioElement;

	@FindBy(id = "benzradio")
	WebElement benzRadioElement;

	@FindBy(id = "hondaradio")
	WebElement hondaRadioElement;

	@FindBy(id = "bmwcheck")
	WebElement bmwCheckbox;

	@FindBy(id = "benzcheck")
	WebElement benzCheckbox;

	@FindBy(id = "hondacheck")
	WebElement hondaCheckbox;
	
	@FindBy(id = "openwindow")
	WebElement OpenWindowButton;
	
	@FindBy(id = "opentab")
	WebElement OpenNewTab;
	
	@FindBy(id = "carselect")
	WebElement dropdownElement;
	
	@FindBy(id = "multiple-select-example")
	WebElement multipleSelectDropdown;
	
	@FindBy(id = "autosuggest")
	WebElement autoSuggestInputElement;
	
	@FindBy(xpath = "//ul[@id = \"ui-id-1\"]/li")
	List<WebElement> suggestionList;
	
	@FindBy(id = "enabled-example-input")
	WebElement enabledDisabledInputField;
	
	@FindBy(id = "disabled-button")
	WebElement disableButton;
	
	@FindBy(id = "enabled-button")
	WebElement enableButton;
	
	@FindBy(id = "hide-textbox")
	WebElement hideTextboxButton;
	
	@FindBy(id = "show-textbox")
	WebElement showTextboxButton;
	
	@FindBy(id = "displayed-text")
	WebElement hideShowInputElement;
	
	@FindBy(id = "alertbtn")
	WebElement alertButton;
	
	@FindBy(id = "confirmbtn")
	WebElement confirmButton;
	
	@FindBy(id = "mousehover")
	WebElement mouseHoverButton;

	@FindBy(xpath = "//a[text() = \"Top\"]")
	WebElement topAnchorElement;
	
	@FindBy(xpath = "//a[text() = \"Reload\"]")
	WebElement reloadAnchorElement;
	
	@FindBy(id = "product")
	WebElement webTableElement;
	
	@FindBy(id = "courses-iframe")
	WebElement allCoursesIFrame;
	
	@FindBy(xpath = "//input[@id = \"search\"]")
	WebElement iFrameSearchField;
	
	@FindBy(xpath = "//h1[text() = \"All Courses\"]")
	WebElement iFrameMainHeading;

	// Actions

	// Method to select Radio Button
	public void selectRadioButton(String option) {

		switch (option.toLowerCase()) {

		case "bmw":
			onClick(bmwRadioElement);
			break;
		case "benz":
			onClick(benzRadioElement);
			break;
		case "honda":
			onClick(hondaRadioElement);
			break;
		}
	}

	// Method to check whether given Radio Button is selected or not
	public boolean isRadioButtonSelected(String option) {

		switch (option.toLowerCase()) {

		case "bmw":
			return bmwRadioElement.isSelected();
		case "benz":
			return benzRadioElement.isSelected();
		case "honda":
			return hondaRadioElement.isSelected();
		default:
			return false;
		}
	}

	// Method to select Checkbox
	public void selectCheckBox(String checkbox) {

		switch (checkbox.toLowerCase()) {

		case "bmw":
			onClick(bmwCheckbox);
			break;
		case "benz":
			onClick(benzCheckbox);
			break;
		case "honda":
			onClick(hondaCheckbox);
			break;
		}
	}

	// Method to check whether given Radio Button is selected or not
	public boolean isCheckboxSelected(String checkbox) {

		switch (checkbox.toLowerCase()) {

		case "bmw":
			return bmwCheckbox.isSelected();
		case "benz":
			return benzCheckbox.isSelected();
		case "honda":
			return hondaCheckbox.isSelected();
		default:
			return false;
		}
	}
	
	// Method to click "Open Window" Button
	public void clickOnOpenWindowButton() {
		onClick(OpenWindowButton);
	}
	
	// Method to switch to new Window
	public void switchToNewWindow() {
		
		String mainWindow = driver.getWindowHandle();
		
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
	}
	
	// Method to Close new window and switch back
	public void closeNewWindowAndSwitchBack() {
		
		driver.close();
		
		for (String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			break;
		}
		
	}
	
	// Method to click "Open Tab" button
	public void clickOnOpenTabButton() {
		onClick(OpenNewTab);
	}
	
	// Method to Switch to new Tab
	public void switchToNewTab() {
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
	}
	
	// Method to switch back to main tab and close the new tab
	public void switchBackToMainTab() {
		
		driver.close();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
	}
	
	// Method to select an option from the dropdown
	public void selectOptionFromDropdown(String option) {
		onSelect(dropdownElement, option);
	}
	
	// Method to verify the selected Option from dropdown
	public String getSelectedDropdownValue() {
		return getSelectedDropdownOption(dropdownElement);
	}
	
	// Method to select multiple options in multi-select dropdown
	public void selectMultipleOptionsFromDropdown(List<String> options) {
		multiSelect(multipleSelectDropdown, options);
	}
	
	// Method to get all selected options from multi select dropdown
	public List<String> getAllSelectedOptionsFromDropdown() {
		return getAllSelectedOptions(multipleSelectDropdown);
	}
	
	// Method to enter text inside auto suggestion input field
	public void enterAutoSuggestInputText(String text) {
		
		autoSuggestInputElement.clear();
		enterText(autoSuggestInputElement, text);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id = \"ui-id-1\"]/li")));
	    
	}
	
	// Method to select desired option from suggestion list
	public void selectSuggestionFromSuggestionList(String optionToSelect) {
		
		for (WebElement suggestion: suggestionList) {
			
			if (suggestion.getText().equalsIgnoreCase(optionToSelect)) {
				onClick(suggestion);
				break;
			}
				
		}
		
	}
	
	// Method to get selected value from auto-suggest field
	public String getSelectedAutoSuggestFieldValue() {
		return autoSuggestInputElement.getAttribute("value");
	}
	
	// Method to click the Enable button
	public void clickEnableButton() {
		onClick(enableButton);
	}
	
	// Method to click the Disable button
	public void clickDisableButton() {
		onClick(disableButton);
	}
	
	// Method to check whether input field is enabled or disabled
	public boolean isInputEnabled() {
		return enabledDisabledInputField.isEnabled();
	}
	
	// Method to make the textBox hidden
	public void hideTextBox() {
		onClick(hideTextboxButton);
	}
	
	// Method to make the textBox visible
	public void showTextBox() {
		onClick(showTextboxButton);
	}
	
	// Method to check whether textbox is hidden or visible
	public boolean isTextboxDisplayed() {
		return hideShowInputElement.isDisplayed();
	}
	
	// Method to click on Alert button
	public void clickAlertButton() {
		onClick(alertButton);
	}
	
	// Method to click on Confirm button
	public void clickConfirmButton() {
		onClick(confirmButton);
	}
	
	// Method to get alert text
	public String getAlertText() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		return alert.getText();
		
	}
	
	// Method to accept the alert
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	// Method to dismiss the alert
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	// Method to hover over "Mouse Hover" button
	public void hoverOverMouseHoverButton() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHoverButton).perform();
		
	}
	
	// Method to check the visibility of "Top" option
	public boolean isTopOptionDisplayed() {
		return topAnchorElement.isDisplayed();
	}
	
	// Method to check the visibility of "Reload" option
	public boolean isReloadOptionDisplayed() {
		return reloadAnchorElement.isDisplayed();
	}
	
	// Method to select "Top" option
	public void selectTopOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(topAnchorElement));
		
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topAnchorElement);
	    
		onClick(topAnchorElement);
	}
	
	// Method to select "Reload" option
	public void selectReloadOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(reloadAnchorElement));
		
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reloadAnchorElement);

		onClick(reloadAnchorElement);
	}
	
	// Method to check whether web table is visible or not
	public boolean isWebTableDisplayed() {
		return webTableElement.isDisplayed();
	}
	
	// Method to retrieve Data Table data
	public List<Map<String, String>> getTableData() {
		
		List<Map<String, String>> tableData = new ArrayList<>();
		List<WebElement> rows = webTableElement.findElements(By.tagName("tr"));
		
		// fetch headers
		List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));
		String[] columnNames = new String[headers.size()];
		
		for (int i=0; i<headers.size(); i++) {
			columnNames[i] = headers.get(i).getText().trim();
		}
		
		// table rows
		for (int i=1; i<rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			Map<String, String> rowData = new HashMap<>();
			
			for (int j=0; j<cells.size(); j++) {
				rowData.put(columnNames[j], cells.get(j).getText().trim());
			}
			tableData.add(rowData);
		}
		
		return tableData;
		
	}
	
	// Method to get iFrame title
	public String getIFrameTitle() {
//		WebElement titleElement = driver.findElement(By.tagName("title"));
//		return driver.switchTo().frame(allCoursesIFrame).getTitle();
//		return titleElement.getText();
//		return driver.switchTo().frame(allCoursesIFrame).getTitle();
		return iFrameMainHeading.getText();
	}
	
	// Method to switch to All Courses iFrame
	public void switchToIFrame() {
//		driver.switchTo().frame(allCoursesIFrame);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(allCoursesIFrame));
	}
	
	// Method to input Text inside iFrame search field
	public void fillIFrameSearchField(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(iFrameSearchField));
		
		iFrameSearchField.clear();
		enterText(iFrameSearchField, text);
	}
	
	// Method to get text from iFrame search Field
	public String getIFrameSearchInputText() {
		return iFrameSearchField.getAttribute("value");
	}
	
}
