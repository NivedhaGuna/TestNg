package org.testng;

import java.time.Duration;

import org.helper.LibGlobalHelper;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Selecting3 extends LibGlobalHelper {

	
	@BeforeMethod
	private void beforeTc() {
		getDateAndTime();
	}
	
	@AfterMethod
	private void afterTc() {
		getDateAndTime();
	}
	
	@Test
	private void tc8() {
		driver.findElement(By.xpath("//button[@class='header-account__content-logo']")).click();
		driver.findElement(By.xpath("//button[text()='Log in here.']")).click();
	}
	
	@Parameters({"Email", "Password"})
	@Test
	private void tc9(String v1 , String v2) {
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(v1);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(v2);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
	}
	
	@Test
	private void tc10() {
		String url = fetchUrl();
		SoftAssert s = new SoftAssert();
		s.assertTrue(url.contains("challenge"), "Test case passed");
	}
	
	@BeforeClass
	private void beforeAllTc() {
		openFirefox();
		launchUrl("https://www.frankandoak.com/");
		maxWindow();
		implicitWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	private void afterAllTc() {
		closeBrowser();

	}
}
