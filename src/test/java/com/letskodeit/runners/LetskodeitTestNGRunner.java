package com.letskodeit.runners;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features/",
		glue= {"com.letskodeit.stepDefinitions", "com.letskodeit.hooks"},
		tags = "@RegistrationTests or @LoginTests or @HomePageTests or @PracticePageTests or @AllCoursesTests or @EcommercePracticeTests",
		plugin = {
		            "pretty",
		            "html:target/cucumber-reports.html",
		            "json:target/cucumber.json",
		            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		        }
)
public class LetskodeitTestNGRunner extends AbstractTestNGCucumberTests {
	
	public static String browser;
	public static String url;
	
	@BeforeTest
	@Parameters({"browser", "url"})
	public void setup(String browserParam, String urlParam) {
		
//		System.out.println("Browser param recieved inside Runner file: " + browserParam);
//		System.out.println("URL Param recieved in Runner File: " + urlParam);
		
		browser = browserParam;
		url = urlParam;
		
	}
	
}
