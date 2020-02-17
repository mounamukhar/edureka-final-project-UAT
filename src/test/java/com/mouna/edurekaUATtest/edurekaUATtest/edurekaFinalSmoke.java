package com.mouna.edurekaUATtest.edurekaUATtest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class edurekaFinalSmoke {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public static void executionSetup() {
		//Runs before all methods
		Reporter.log("Initialize browser and navigate to home page.");
		System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver_mac");
		driver = new ChromeDriver();		
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public static void validatePageTitle() {
		//Test case 1
		Reporter.log("Perform test execution.");		
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");		
	}
	
	
	@Test
	public static void validateStringPresent() {
		//Test case 2
		Reporter.log("Perform string validation.");		
		try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//font[contains(text(),'Name:')]"));
				Reporter.log("Tet found as expected.");
			} catch (NoSuchElementException e) {
				Assert.fail("Text not present.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
	@AfterMethod
	public static void executionCleanup() {
		//Runs after all methods
		Reporter.log("Finish execution and clean up instances.");
		driver.quit();
		
	}

}
