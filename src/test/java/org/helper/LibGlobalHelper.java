package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobalHelper extends ExcelSheetHelper {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Robot r;
	public static Actions ac;
	public static Select s;
	TakesScreenshot ts;
	public static Alert a;

	public static void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void openEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	public static void openFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void maxWindow() {

		driver.manage().window().maximize();
	}

	public static void minWindow() {

		driver.manage().window().minimize();
	}

	public static String fetchTitle() {

		String titleName = driver.getTitle();
		System.out.println(titleName);
		return titleName;
	}

	public static String fetchUrl() {

		String url = driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}
	
	public static void getAttribute(WebElement ele , String name) {
		String txt = ele.getAttribute(name);
		System.out.println(txt);
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void hold(int time) throws InterruptedException {

		Thread.sleep(time);
	}
	
	public static void getDateAndTime() {
		Date d = new Date();
		System.out.println(d);

	}

	public static void acceptAlert() {
	    a = driver.switchTo().alert();
		a.accept();
	}
	
	public static void alertSendkeys(String val) {
	    a = driver.switchTo().alert();
		a.sendKeys(val);
	}
	
	public void getTextAlert() {
		a=driver.switchTo().alert();
		String txt = a.getText();
		System.out.println(txt);
		a.accept();
	}

	public static void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static void scrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView(false)", element);
	}

	public void setAttribute(WebElement ele, String value, String txt) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','txt')", ele);
	}
	
	public void getAttributejs(WebElement ele, String value, String txt) {
		js = (JavascriptExecutor) driver;
		 Object o1 = js.executeScript("arguments[0].gettAttribute('value','txt')", ele);
		 System.out.println(o1);
	}

	public void screenShot(String url) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File(url);
		FileUtils.copyFile(src, des);
	}

	public static void fillTextbox(WebElement ele, String input) {
		ele.sendKeys(input);
	}

	public static void toClick(WebElement element) {
		element.click();
	}

	public static void toReload() {
		driver.navigate().refresh();
	}

	public static void copyUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void pasteUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public void enterUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void keyDown() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public void tab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void dragAndDrop(WebElement src, WebElement des) {
		ac = new Actions(driver);
		ac.dragAndDrop(src, des).perform();

	}

	public void rightClick(WebElement ele) {
		ac = new Actions(driver);
		ac.contextClick(ele).perform();
	}

	public void moveToElement(WebElement src) {
		ac = new Actions(driver);
		ac.moveToElement(src).perform();
	}

	public void frameById(WebElement id) {
		driver.switchTo().frame(id);

	}

	public void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void frameByElement(WebElement name) {
		driver.switchTo().frame(name);
	}

	public static void windowHandling(int num) {
		Set<String> allWindowId = driver.getWindowHandles();
		List<String> allId = new LinkedList<String>(allWindowId);
		System.out.println(allId);
		driver.switchTo().window(allId.get(num));
	}

	public static void selectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectByText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);

	}

	public static void selectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}
	
	public static void getOptions(WebElement element) {
		s = new Select(element);
		s.getOptions();
	}

	public static void allOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> allOptions = s.getOptions();
		System.out.println("All options:");
		for (WebElement eachopt : allOptions) {
			String txt = eachopt.getText();
			System.out.println(txt);
		}

	}

	public static void deSelectAll(WebElement element) {
		s = new Select(element);
		s.deselectAll();
	}

	public static void deselectBytext(WebElement element, String text) {
		s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public static void deselectByValue(WebElement element, String value) {
		s = new Select(element);
		s.deselectByValue(value);
	}

	public static void deselectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.deselectByIndex(index);
	}

	public void implicitWait(Duration Duration) {
		driver.manage().timeouts().implicitlyWait(Duration);
	}

	
	public void screenshot(String name) throws IOException {
		ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Nive\\java selenium\\Eclipse\\FrankAndOak\\Screenshots"+name+".jpg");
		FileUtils.copyFile(src, des);

	}
}
