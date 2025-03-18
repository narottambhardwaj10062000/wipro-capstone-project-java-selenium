package com.letskodeit.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letskodeit.basepage.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath = "//nav//a")
	private List<WebElement> navSections;
	
	// Actions
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	// method to check whether a given section is being displayed or not
	public boolean isSectionDisplayed(String sectionName) {
		
		for (WebElement section: navSections) {
			
//			System.out.println("Expected name: " + sectionName );
//			System.out.println("Actual name: " + section.getText().trim());
			
			if (section.getText().trim().equals(sectionName)) {
				return section.isDisplayed();
			}
			
		}
		
		return false;
		
	}
	
	
}
