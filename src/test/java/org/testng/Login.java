package org.testng;

import java.time.Duration;

import org.helper.LibGlobalHelper;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login extends LibGlobalHelper {

	@Test
	private void tc11() {
		driver.findElement(By.xpath("//button[@class='header-account__content-logo']")).click();
		driver.findElement(By.xpath("//button[text()='Log in here.']")).click();
	}
	
	@Test(dataProvider = "login")
	private void tc12(String v1 , String v2) {
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(v1);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(v2);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
	}
	
	@Test
	private void tc13() {
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
	
	@DataProvider(name = "login")
	public String[][] loginData() {
		return new String[][] {
			{"dev@123","dev2345"}, 
			{"nive@gmail.com" , "nivedha"},
			{"srithar@gmail.com", "123456"},
			{"9876543245" , "selenium"},
			{"java@gmail.com", "java123"}
		};
	}
}
