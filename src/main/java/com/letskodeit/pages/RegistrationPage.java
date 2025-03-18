package com.letskodeit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letskodeit.basepage.BasePage;

public class RegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath = "//a[text() = \"Sign In\"]")
	private WebElement signInLink;
	
	@FindBy(xpath = "//a[text() = \" Sign Up\"]")
	private WebElement signUpLink;
	
	@FindBy(xpath = "//input[@placeholder = \"First Name\"]")
	private WebElement firstName;
	
	@FindBy(id = "last_name")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder= \"Email Address\"]")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "password_confirmation")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@value= \"Sign Up\"]")
	private WebElement signUpButton;
	
	@FindBy(tagName = "input")
	private List<WebElement> inputFields;
	
	@FindBy(xpath = "//span[contains(@class, \"help-block\")]")
	private WebElement passwordMismatchError;
	
	// Actions
	
	public void navigateToSignInPage() {
		onClick(signInLink);
	}
	
	public void navigateToSignUpPage() {
		onClick(signUpLink);
	}
	
	public void fillRegistrationForm(String firstNameText, String lastNameText, String emailText, String passwordText, String confirmPasswordText){
		enterText(firstName, firstNameText);
		enterText(lastName, lastNameText);
		enterText(email, emailText);
		enterText(password, passwordText);
		enterText(confirmPassword, confirmPasswordText);
	}
	
	public void clickOnSignUpButton() {
		onClick(signUpButton);
	}
	
	// Method to find first invalid field
	public WebElement getFirstInvalidField() {
		for (WebElement field: inputFields) {
			if (!field.isDisplayed()) continue; // ignore hidden fields
			if (!field.getAttribute("validationMessage").isEmpty()) {
				return field;  // Returns the first field with an error
			}
		}
		return null; // No invalid fields found
	}
	
	// Method to check if password and confirm Password match
	public boolean isPasswordMismatchErrorDisplayed() {
		try {
			return passwordMismatchError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
