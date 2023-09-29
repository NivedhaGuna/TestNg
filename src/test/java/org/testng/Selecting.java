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

public class Selecting extends LibGlobalHelper{
	
	@BeforeMethod
	private void beforeTc() {
		getDateAndTime();
	}
	
	@AfterMethod
	private void afterTc() {
		getDateAndTime();
	}
	
	@Test
	private void tc1() {
		fetchTitle();
		System.out.println("TC1 :"+ Thread.currentThread().getId());
	}
	
	@Test
	private void tc2() {
		WebElement select = driver.findElement(By.xpath("//span[text()='Shop women']"));
		toClick(select);
		driver.findElement(By.xpath("(//p[contains(text(),'Ribbed Top')])[1]")).click();	
		System.out.println("TC2 :"+ Thread.currentThread().getId());
	}
	
	@Test()
	private void tc3() {
		driver.findElement(By.xpath("//div[text()='XL']")).click();
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
		System.out.println("TC3 :"+ Thread.currentThread().getId());
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
