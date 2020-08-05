package com.mouna.edurekaUATtest.edurekaUATtest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class edurekaFinalSmoke {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public static void executionSetup() throws InterruptedException {
		//Runs before all methods
		Thread.sleep(20000);
		Reporter.log("Initialize browser and navigate to home page.");
		System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver_mac");
		driver = new ChromeDriver();
		driver.get("http://www.homedepot.com");
	}
	
	@Test
	public static void validatePageTitle() {
		//Test case 1
		Reporter.log("Perform test execution.");		
		Assert.assertEquals(driver.getTitle(), "The Home Depot");
	}
	
	
	@Test
	public static void validateStringPresent() {
		//Test case 2
		Reporter.log("Perform string validation.");		
		try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='MyStore__store']"));
				Reporter.log("Store information displayed on page.");
			} catch (NoSuchElementException e) {
				Assert.fail("Store information not displayed.");
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
