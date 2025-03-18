package com.letskodeit.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.letskodeit.hooks.Hooks;
import com.letskodeit.pages.ECommercePracticePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ECommercePageStepDefinitions {
	
	WebDriver driver = Hooks.driver;
	ECommercePracticePage ecommerce = new ECommercePracticePage(driver);
	
	@Given("the eCommerce page is open")
	public void the_e_commerce_page_is_open() {
		
	    driver.get("https://ecommercepractice.letskodeit.com/");
	    
	    String expectedUrl = "https://ecommercepractice.letskodeit.com/";
	    String actualUrl = driver.getCurrentUrl();
	    
	    Assert.assertEquals(actualUrl, expectedUrl, "wrong url");
	    
	}

	@When("the user adds the item {string} to the cart")
	public void the_user_adds_the_item_to_the_cart(String itemName) throws InterruptedException {
		
		ecommerce.selectAnItem();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://ecommercepractice.letskodeit.com/product/sample"));
		
		String expectedUrl = "https://ecommercepractice.letskodeit.com/product/sample";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl, "could not navigate to product detail page");
		
		ecommerce.addToBag();

	}

	@When("the user clicks on go to cart button")
	public void the_user_clicks_on_go_to_cart_button() {
		
		ecommerce.clickOnGoToCart();

	}

	@Then("the item {string} should be displayed in the cart")
	public void the_item_should_be_displayed_in_the_cart(String string) {

	}

	@When("the user proceeds to checkout")
	public void the_user_proceeds_to_checkout() {

		ecommerce.proceedToCheckout();
		
	}

	@Then("the checkout page should be displayed")
	public void the_checkout_page_should_be_displayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://ecommercepractice.letskodeit.com/cart"));

		String expectedUrl = "https://ecommercepractice.letskodeit.com/cart";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl, "wrong url");
		
	}
	
	@When("the user clicks the checkout button")
	public void the_user_clicks_the_checkout_button() {
	    
		ecommerce.proceedToCheckout();
		
	}

	@Then("the order confirmation page should be displayed")
	public void the_order_confirmation_page_should_be_displayed() {
	    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://ecommercepractice.letskodeit.com/orderConfirm"));
		
		String expectedUrl = "https://ecommercepractice.letskodeit.com/orderConfirm";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl, "order not placed successfully");
	}

}
