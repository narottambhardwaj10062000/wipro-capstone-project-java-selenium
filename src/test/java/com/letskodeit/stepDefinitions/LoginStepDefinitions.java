package com.letskodeit.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.letskodeit.hooks.Hooks;
import com.letskodeit.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	WebDriver driver = Hooks.driver;
	LoginPage loginPage = new LoginPage(driver);
	
	@Given("the login page is open")
	public void the_login_page_is_open() throws InterruptedException {
		
		// maximizing the window
	    driver.manage().window().maximize();
	    System.out.println("Current URL (inside Login Step Definition File): " + driver.getCurrentUrl());
	    
	    // navigate to signIn page
	    loginPage.navigateToSignInPage();
	    
	    System.out.println("tried navigating to signIn Page: " + driver.getCurrentUrl());
	    System.out.println("Successfully navigated to Login Page" + driver.getCurrentUrl());
	    
	    Thread.sleep(2000);
	}

	@When("the username {string} and password {string} are entered")
	public void the_username_and_password_are_entered(String email, String password) throws InterruptedException {
		
		// Filling up the login Form
		System.out.println("Email: " + email + "Password: " + password);
		loginPage.fillLoginForm(email, password);
	    
	}

	@When("the login button is clicked")
	public void the_login_button_is_clicked() throws InterruptedException {
	    
		// Clicking on login Button
		loginPage.clickOnLoginButton();
		System.out.println("Login Button Clicked");
		Thread.sleep(5000);
	}

	@Then("the message {string} should be displayed")
	public void the_message_should_be_displayed(String expectedMessage) {
		
		String actualMessage = "";
		
		// if login is successful, check if the URL changed or not
		if (driver.getCurrentUrl().equals("https://www.letskodeit.com/")) {
			System.out.println("User Login was Successful");
			actualMessage = "Login Successful";
		} 
		
		// if login was not successful 
		else {
			
			List<WebElement> errorMessages = driver.findElements(By.xpath("//span[@class = \"error\"]"));
			
			for (WebElement error: errorMessages) {
				String message = "";
				
				if (error.isDisplayed()) {
					message = error.getText();
					actualMessage += message;
					message = "";
				}
			}
		}
		
		System.out.println("Actual message is: " + actualMessage);
		System.out.println("Expected message is: " + expectedMessage);
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
		
	}
	
	

}
