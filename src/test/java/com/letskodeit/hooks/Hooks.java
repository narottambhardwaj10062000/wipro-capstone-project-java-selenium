package com.letskodeit.hooks;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.letskodeit.runners.LetskodeitTestNGRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		
		String browser = LetskodeitTestNGRunner.browser;
		String url = LetskodeitTestNGRunner.url;
		
		switch(browser.toLowerCase()) {
			case "edge":
				driver = new EdgeDriver();
				break;
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalArgumentException(browser + " Browser not supported");
				
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
