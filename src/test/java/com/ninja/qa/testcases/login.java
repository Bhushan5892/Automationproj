package com.ninja.qa.testcases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class login extends Base  {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL("Chrome");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifyloginwithvalidcredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys("mr.bhushansatpute@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Bhushan7@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
        
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
	}
	@Test(priority=2)
	public void verifyloginwithinvalidcredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Bhushan77@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualwarnningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedwarnningmessage = "Warning: No match for E-Mail Address and/or Password." ;
        Assert.assertTrue(actualwarnningmessage.contains(expectedwarnningmessage),"Expected warnning message is not dispaly");
	
		
	}
	@Test(priority=3)
	public void verifyloginwithInvalidEmailAndValidPassword() {
	 
		driver.findElement(By.id("input-email")).sendKeys (Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Bhushan7@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualwarnningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedwarnningmessage = "Warning: No match for E-Mail Address and/or Password." ;
        Assert.assertTrue(actualwarnningmessage.contains(expectedwarnningmessage),"Expected warnning message is not dispaly");
		
	}
	@Test(priority=4)
	public void verifyloginwithValidEmailAndInvalidPassword() {
		
		driver.findElement(By.id("input-email")).sendKeys("mr.bhushansatpute@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Bhushan789@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualwarnningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedwarnningmessage = "Warning: No match for E-Mail Address and/or Password." ;
        Assert.assertTrue(actualwarnningmessage.contains(expectedwarnningmessage),"Expected warnning message is not dispaly");
		
	}
	@Test(priority=5)
	public void verifyloginWithoutProvidingCredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualwarnningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedwarnningmessage = "Warning: No match for E-Mail Address and/or Password." ;
        Assert.assertTrue(actualwarnningmessage.contains(expectedwarnningmessage),"Expected warnning message is not dispaly");
		
	}
	
}
