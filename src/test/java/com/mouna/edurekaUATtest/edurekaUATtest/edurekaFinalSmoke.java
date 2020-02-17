package com.mouna.edurekaUATtest.edurekaUATtest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		System.setProperty("webdriver.gecko.driver","src/resources/driver/geckodriver_linux64");
		driver = new FirefoxDriver();
		driver.get("http://localhost:5000");
	}
	
	@Test
	public static void validatePageTitle() {
		//Test case 1
		Reporter.log("Perform test execution.");		
		Assert.assertEquals(driver.getTitle(), "superServe");
	}
	
	
	@Test
	public static void validateStringPresent() {
		//Test case 2
		Reporter.log("Perform string validation.");		
		try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//p[contains(text(),'Hello There. This is superServe.')]"));
				Reporter.log("Text found as expected: Hello There. This is superServe. ");
			} catch (NoSuchElementException e) {
				Assert.fail("Hello There. This is superServe. : Text not present!");
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
