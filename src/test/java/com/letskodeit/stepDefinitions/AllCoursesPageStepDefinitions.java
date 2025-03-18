package com.letskodeit.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.letskodeit.hooks.Hooks;
import com.letskodeit.pages.AllCoursesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllCoursesPageStepDefinitions {
	
	WebDriver driver = Hooks.driver;
	AllCoursesPage allCourses = new AllCoursesPage(driver);
	
	@Given("the All Courses page is open")
	public void the_all_courses_page_is_open() {
	    
		// navigate to All Courses Page
		driver.get("https://www.letskodeit.com/courses");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("/courses"));
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/courses"), "required url not found");
	}

	@When("the category filter is set to {string}")
	public void the_category_filter_is_set_to(String categoryName) {
	    
		allCourses.selectCategoryFromDropdown(categoryName);
		
	}

	@Then("the URL should contain {string}")
	public void the_url_should_contain(String categoryUrl) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("/category"));
		
		Assert.assertTrue(driver.getCurrentUrl().contains(categoryUrl), "cant find results for category: " + categoryUrl);
	    
	}
	
	@When("{string} is entered in the search field")
	public void is_entered_in_the_search_field(String searchText) {
		allCourses.enterSearchText(searchText);
	}

	@Then("all displayed course titles should contain {string}")
	public void all_displayed_course_titles_should_contain(String searchText) {
	    Assert.assertTrue(allCourses.doesCoursesContainSearchText(searchText), "search result is not correct");
	}

}
