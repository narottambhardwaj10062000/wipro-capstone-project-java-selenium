package com.letskodeit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letskodeit.basepage.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath = "//a[text() = \"Sign In\"]")
	private WebElement signInLink;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "login-password")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	// Actions
	
	public void navigateToSignInPage() {
		onClick(signInLink);
	}
	
	public void fillLoginForm(String emailText, String passwordText) throws InterruptedException {
		
		enterText(email, emailText);
		enterText(password, passwordText);
		
	}
	
	public void clickOnLoginButton() {
		onClick(loginButton);
	}
	
	
	
	
	

}
