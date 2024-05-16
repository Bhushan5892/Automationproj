package com.ninja.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class search extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		initializeBrowserAndOpenApplicationURL("chrome");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifySearchWithValidProduct() {
		
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText(" HP LP3060")).isDisplayed(),"valid product HP is not display");
	}

}
