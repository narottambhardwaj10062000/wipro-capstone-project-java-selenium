package com.letskodeit.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letskodeit.basepage.BasePage;

public class AllCoursesPage extends BasePage {
	
	WebDriver driver;
	
	public AllCoursesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath = "//select[@name = \"categories\"]")
	WebElement selectCategoryDropdown; 
	
	@FindBy(xpath = "//input[@id = \"search\"]")
	WebElement searchInputField;
	
	@FindBy(xpath = "//h4[@class = \"dynamic-heading\"]")
	List<WebElement> searchResultCourseTitles;
	
	@FindBy(xpath = "//button[@type='submit' and contains(@class, 'search-course')]")
	WebElement searchButton;
	
	
	// Actions
	
	// Method to select category from dropdown
	public void selectCategoryFromDropdown(String option) {
		onSelect(selectCategoryDropdown, option);
	}
	
	// Method to enter text inside search input field
	public void enterSearchText(String searchText) {
		
		enterText(searchInputField, searchText);
		onClick(searchButton);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h4[@class = \"dynamic-heading\"]"), searchText));

	}
	
	// Method to check whether all the courses contain search text or not
	public boolean doesCoursesContainSearchText(String searchText) {
		
		
		
		for (WebElement courseTitle: searchResultCourseTitles) {
			if (!courseTitle.getText().toLowerCase().contains(searchText.toLowerCase())) {
				return false;
			}
		}
		
		return true;
	}
	
	

}
