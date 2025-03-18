package com.letskodeit.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.letskodeit.hooks.Hooks;
import com.letskodeit.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDefinitions {
	
	WebDriver driver = Hooks.driver;
	HomePage homePage = new HomePage(driver);
	
	@Given("the home page is open")
	public void the_home_page_is_open() {
		
		String expectedUrl = "https://www.letskodeit.com/";
		String actualUrl = driver.getCurrentUrl();
		
		if (actualUrl.equals(expectedUrl)) {
			System.out.println("current Url (from HomePage Step Definition): " + actualUrl);
		}
		
		Assert.assertEquals(expectedUrl, actualUrl);
	    
	}

	@Then("the title of the page should be {string}")
	public void the_title_of_the_page_should_be(String expectedTitle) {
		
		String actualTitle = homePage.getPageTitle();
		
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title verification successful");
		}
		
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}

	@Then("the following sections should be visible:")
	public void the_following_sections_should_be_visible(List<String> expectedSections) {
	    
		for (String section: expectedSections) {
			Assert.assertTrue(homePage.isSectionDisplayed(section));
			System.out.println(section + " display test successful");
		}
	}

}
