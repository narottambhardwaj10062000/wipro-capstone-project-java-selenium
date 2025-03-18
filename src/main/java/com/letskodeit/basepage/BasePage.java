package com.letskodeit.basepage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	WebDriver webDriver;
	
	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void onClick(WebElement element) {
		element.click();
	}
	
	public void onSelect(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public String getSelectedDropdownOption(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void multiSelect(WebElement element, List<String> options) {
		
		Select select = new Select(element);
		
		for (String option: options) {
			select.selectByVisibleText(option);
		}
	}
	
	public List<String> getAllSelectedOptions(WebElement element) {
		
		Select select = new Select(element);
		
		List<WebElement> allSelectedElements = select.getAllSelectedOptions();
		List<String> allSelectedOptions = new ArrayList<>();
		
		for (WebElement ele: allSelectedElements) {
			allSelectedOptions.add(ele.getText());
		}
		
		return allSelectedOptions;
		
	}
}
