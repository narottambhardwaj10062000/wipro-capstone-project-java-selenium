package com.letskodeit.stepDefinitions;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.letskodeit.hooks.Hooks;
import com.letskodeit.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinitions {
	
	WebDriver driver = Hooks.driver;
	RegistrationPage registerPage = new RegistrationPage(driver);
	
	
	@Given("the registration page is open")
	public void the_registration_page_is_open() throws InterruptedException {
		
		// maximizing the window
		driver.manage().window().maximize();
		System.out.println("Current URL (inside Resistration Step Definition): " + driver.getCurrentUrl());
		
		// navigate to login page 
		registerPage.navigateToSignInPage();
		System.out.println("navigated To: " + driver.getCurrentUrl());
		Thread.sleep(2000);
		
		// now Navigate to signUp Page
		registerPage.navigateToSignUpPage();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.letskodeit.com/register";
		
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("navigated To: " + driver.getCurrentUrl());
		
		Thread.sleep(2000);
	    
	}

	@When("the user enters {string}, {string}, {string}, {string}, and {string}")
	public void the_user_enters_and(String firstName, String lastName, String email, String password, String confirmPassword) {
	    registerPage.fillRegistrationForm(firstName, lastName, email, password, confirmPassword);
	    System.out.println("Registration form filled");
	}

	@When("the user solves the CAPTCHA manually")
	public void the_user_solves_the_captcha_manually() throws InterruptedException {
	    System.out.println("Solve the CAPTCHA and press ENTER to continue...");
	    Scanner scanner = new Scanner(System.in);
	    scanner.nextLine(); // waits for the input before proceeding
	    System.out.println("CAPTCHA solved successfully");
	    Thread.sleep(2000);
	}

	@When("the register button is clicked")
	public void the_register_button_is_clicked() {
		
		registerPage.clickOnSignUpButton();
		System.out.println("Register submit button clicked....");
	    
	}

	@Then("the message {string} should be displayed on registration")
	public void the_message_should_be_displayed_on_registration(String expectedMessage) {
	    
		String actualMessage = "";
		
		if (expectedMessage.equals("Registration successful")) {
			
			String expectedUrl = "https://www.letskodeit.com/";
			String actualUrl = driver.getCurrentUrl();
			
			System.out.println("Expected Url after Registration: " + expectedUrl);
			System.out.println("Actual Url after Registration: " + actualUrl );
			
			if(actualUrl.equals(expectedUrl)) {
				System.out.println("User Registration Successful...");
				actualMessage = "Registration successful";
			}
			
			Assert.assertEquals(actualUrl, expectedUrl);
			
		} else if (expectedMessage.equals("Passwords do not match") || expectedMessage.equals("The password must be at least 6 characters.")) {
			
			System.out.println("is there any password mismatch: " + registerPage.isPasswordMismatchErrorDisplayed());
			
			if (registerPage.isPasswordMismatchErrorDisplayed()) {
				actualMessage = expectedMessage;
			}
			
			Assert.assertTrue(registerPage.isPasswordMismatchErrorDisplayed());
			
		} else {
			WebElement invalidField = registerPage.getFirstInvalidField();
			
			if (invalidField != null) {
				actualMessage = invalidField.getAttribute("validationMessage");
			} else {
				actualMessage = "No error message displayed";
			}
			
		}
		
		System.out.println("Actual Message: " + actualMessage);
		System.out.println("Expected Message: " + expectedMessage);
		
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
	}

}
