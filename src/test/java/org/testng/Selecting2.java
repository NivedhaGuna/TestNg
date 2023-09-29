package org.testng;

import java.time.Duration;

import org.helper.LibGlobalHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selecting2 extends LibGlobalHelper {


	@BeforeMethod
	private void beforeTc() {
		getDateAndTime();
	}
	
	@AfterMethod
	private void afterTc() {
		getDateAndTime();

	}
	
	@Test
	private void tc4() {
		fetchTitle();	
	}
	
	@Test(retryAnalyzer = FailedClass.class)
	private void tc5() {
		WebElement select = driver.findElement(By.xpath("//span[text()='Shop men']"));
		toClick(select);
		driver.findElement(By.xpath("//p[contains(text(),'The Finn Relaxed')]")).click();
	}
	
	@Test(retryAnalyzer = FailedClass.class)
	private void tc6() {
		driver.findElement(By.xpath("//div[text()='36']")).click();
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
	}
	
	@BeforeClass
	private void beforeAllTc() {
		openFirefox();
		launchUrl("https://www.frankandoak.com/");
		maxWindow();
		implicitWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	private void afterAllTc() {
		closeBrowser();

	}
	
}
