package com.letskodeit.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letskodeit.basepage.BasePage;

public class ECommercePracticePage extends BasePage {
	
	WebDriver driver;
	
	public ECommercePracticePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath = "//div[contains(@class, 'ProductCard-module--detailsContainer')]//span[text()='Classic T-Shirt']/ancestor::div[contains(@class, 'ProductCard-module--root')]")
	List<WebElement> allItemsWithGivenName;
	
	@FindBy(xpath = "//img[@src = \"/products/shirt1.jpg\"]")
	WebElement item;
	
	@FindBy(xpath = "//button[text() = \"Add to Bag\"]")
	WebElement addToBagButton;
	
	@FindBy(xpath = "//button[@aria-label = \"Cart\"]")
	WebElement goToCartButton;
	
	@FindBy(xpath = "//div[@class = \"Drawer-module--content--41faf Drawer-module--showContent--a6527\"]")
	WebElement drawer;
	
	@FindBy(xpath = "//button[text() = \"checkout\"] ")
	WebElement checkoutButton; 
	
	// Actions
	
	// Method to select an item
	public void selectAnItem() {
		
		onClick(item);
		
	}
	
	// Method to click "Add To Bag Button"
	public void addToBag() {
		onClick(addToBagButton);
	}
	
	// Method to click on "go to cart" button
	public void clickOnGoToCart() {
		onClick(goToCartButton);
	}
	
	// Method to proceed to checkout
	public void proceedToCheckout() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		
		onClick(checkoutButton);
		
	}

}
