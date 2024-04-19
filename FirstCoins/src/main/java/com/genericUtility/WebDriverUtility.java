package com.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/**
 * This Class holds all the Webdriver utilities methods
 * 
 * @author Gokul Kandpal
 */
public class WebDriverUtility {

	/**
	 * This method maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This methods waits until page get loaded
	 * 
	 * @param driver
	 * @param sec
	 */
	public void implicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));

	}

	/**
	 * This method waits for element to visible in webpage
	 * 
	 * @param driver
	 * @param sec
	 * @param element
	 */

	public void waitUntilElementToBeVisible(WebDriver driver, int sec, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method waits till element to be clickable
	 * 
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, int sec, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This methods waits for the Page title to be loaded
	 * 
	 * @param driver
	 * @param sec
	 * @param titel
	 */
	public void waitUntilToGetTheTitel(WebDriver driver, int sec, String titel) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(titel));
	}

	/**
	 * This method is used for handel the drop down with visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void selectFromDropDownUsingVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * This method is used for handel the drop down with Index value
	 * 
	 * @param element
	 * @param index
	 */
	public void selectFromDropDownUsingIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	/**
	 * This method is used for handel the drop down with the Value
	 * 
	 * @param element
	 * @param value
	 */

	public void selectFromDropDownUsingValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public Actions performActions(WebDriver driver) {
		return new Actions(driver);
	}

	/**
	 * This method is used for mouse hovering action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	/**
	 * This method is used for drag and drop using source and destination
	 * 
	 * @param driver
	 * @param sourElement
	 * @param destination
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).perform();
	}

	/**
	 * This method is used drag and drop by its axes
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebDriver driver, WebElement element, int x, int y) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y).perform();
	}

	/**
	 * This method is used for double click action
	 * 
	 * @param driver
	 * @param element
	 */

	public void dublicClick(WebDriver driver, WebElement element) {
		performActions(driver).doubleClick(element).perform();
	}

	/**
	 * This method is used for the right click action
	 * 
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver, WebElement element) {
		performActions(driver).contextClick(element).perform();
	}

	/**
	 * This method is used for scroling action till the element using actions class
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToElementUsingActions(WebDriver driver, WebElement element) {

		performActions(driver).scrollToElement(element).perform();
	}

	/**
	 * This method is used for take click and hold action
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {

		performActions(driver).clickAndHold(element).perform();
	}

	/**
	 * This method is used to perform the enter key action
	 * 
	 * @param driver
	 * @param element
	 */
	public void enterKeyPress(WebDriver driver, WebElement element) {

		performActions(driver).sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method is used for Swtiching to any window
	 * 
	 * @param driver
	 * @param titel
	 */
	
	public void pressKeyUsingActions(WebDriver driver, WebElement element) {
		performActions(driver).keyDown(element,Keys.CONTROL).perform();
		
	}
	public void releaseKeyUsingActions(WebDriver driver, WebElement element) {
		performActions(driver).keyUp(element,Keys.CONTROL).perform();
		
	}
	
	public void switchToWindow(WebDriver driver, String titel) {
		Set<String> allIds = driver.getWindowHandles();

		for (String id : allIds) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains(titel)) {
				break;
			}

		}
	}

	/**
	 * For Creating the robot class refernce
	 * 
	 * @return
	 * @throws AWTException
	 */
	public Robot robotAction() throws AWTException {
		Robot r = new Robot();
		return r;
	}

	/**
	 * This method is used for enter press using robot class
	 * 
	 * @throws AWTException
	 */
	public void KeyPressEnter() throws AWTException {
		robotAction().keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used for release enter using robot class
	 * 
	 * @throws AWTException
	 */
	public void KeyReleaseEnter() throws AWTException {
		robotAction().keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * Method is used for switching the frame using the iframe tag index
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, int id) {
		driver.switchTo().frame(id);
	}

	/**
	 * Method is used for switching the frame using the id or name of iframe
	 * 
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	
	

	/**
	 * Method is used for switching the frame using the weblement reference
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Accpting the pop using method
	 * 
	 * @param driver
	 */
	public void alertPopupAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	/**
	 * Closing the pop using this method
	 * 
	 * @param driver
	 */
	public void alertPopupDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method gets the text from the popup
	 * 
	 * @param driver
	 */
	public String alertPopupGetText(WebDriver driver) {

		return driver.switchTo().alert().getText();
	}

	/**
	 * This method is used for send data in pop up text field
	 * 
	 * @param driver
	 * @param msg
	 */
	public void alerPopSendKeys(WebDriver driver, String msg) {
		driver.switchTo().alert().sendKeys(msg);
	}
	
	
	

	/**
	 * This method is used for Taking the Screenshot of the webpage
	 * 
	 * @param driver
	 * @param path
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String name) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		JavaUtility jUtil=new JavaUtility();
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/"+name+ ".png");
		String path=destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
          return path;
	}

	/**
	 * Getting the java script executor reference here
	 * 
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor javaScriptRef(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * Scrolling acction till the element using javascript Executor
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollActionJavaScript(WebDriver driver, WebElement element) {

		javaScriptRef(driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * Scroll till bottom using javaScript executor
	 * 
	 * @param driver
	 */
	public void scrollToBottom(WebDriver driver) {
		javaScriptRef(driver).executeScript("window.scrollBy(0,document.body.scrollHieght)");
	}

	/**
	 * Method Clicks on a element using Javascript Executor
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickByJS(WebDriver driver, WebElement element) {
		javaScriptRef(driver).executeScript("arguments[0].click()", element);
	}

	
	/**
	 * 
	 * @author Gokul Kandpal
	 * @param driver
	 * @param element
	 * @param data
	 */
	
	public void sendData(WebDriver driver,WebElement element, String data) {
		
		
		javaScriptRef(driver).executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	/**
	 * This method is used for scrolling up to elment
	 * @author Gokul Kandpal
	 * @param driver
	 * @param element
	 */
	public void scrollUpTillElementToBeVisible(WebDriver driver,WebElement element) {
		
	        Point p=element.getLocation();
	        
		javaScriptRef(driver).executeScript(" window.scorollBy("+p.getX()+","+p.getY()+")");
	}
	
	
	
	

}
