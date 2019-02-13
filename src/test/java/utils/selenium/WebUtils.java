package utils.selenium;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.Robot;
import java.awt.AWTException;

/**
 * This class contain useful method. Below are some definition:
 * - Visible means that the element is not only displayed but also have a height and width that is greater than 0.
 * - Click-able means that the element is visible and not disabled.
 */
public class WebUtils {
	/**
	 * Wait for the presence/exist of element Located by a locator even it is not presented in DOM yet
	 * @return WebElement
	 */
	public static WebElement findDynamicElement(By locator, int timeOutInSeconds){
		WebDriver driver = DriverBase.getDriver();
		return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
	}


	/**
	 * Verify that an element is visible. Visible means that the element is not only displayed but also have a height and width that is greater than 0.
	 * @return boolean
	 */
	public static boolean isElementVisible(By locator, int timeOutInSeconds){
		try {
			WebDriver driver = DriverBase.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	/**
	 * Click on an element after it is visible and click-able even it is not load in DOM yet.
     * Used when DOM is changed
	 */
	public static void clickWhenReady(By locator, int timeOutInSeconds) throws Exception {
		WebDriver driver = DriverBase.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
		Thread.sleep(100);
	}

    /**
     * Click on an element after it is visible and click-able but this element must load in DOM first.
     * Used when element is disabled
     */
	public static void clickWhenReady(WebElement element, int timeOutInSeconds) throws Exception {
		WebDriver driver = DriverBase.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

    /******************************************************************************************************************
     * Javascript click on an element after it is visible and click-able even it is not load in DOM yet.
	 * Use when normal click does not work and required Javascript action
     */
    public static void clickWhenReadyJavascript (By locator, int timeOutInSeconds) throws Exception {
		WebDriver driver = DriverBase.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

	public static void clickWhenReadyJavascript (WebElement element, int timeOutInSeconds) throws Exception {
		WebDriver driver = DriverBase.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
	}

	/******************************************************************************************************************
	 * Send text to element after it is visible and click-able even it is not load in DOM yet.
     * Used when DOM is changed.
	 */
	public static void sendTextWhenReady(By locator, String text, int timeOutInSeconds) throws Exception {
		WebDriver driver = DriverBase.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
		element.sendKeys(text);
	}
    /**
     * Send text to element after it is visible and click-able even it is not load in DOM yet.
     * Most use when element is disabled.
     */
	public static void sendTextWhenReady(WebElement element, String text, int timeOutInSeconds) throws Exception {
		WebDriver driver = DriverBase.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(text);
	}

	/******************************************************************************************************************
	 * Accept alert when it is displayed
	 */
	public static void acceptAlert(int timeOutInSeconds){
		WebDriver driver = DriverBase.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	/******************************************************************************************************************
	 * Press a key in real Keyboard
	 */
	public static void pressKeyboard(int KeyEvent) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent);
		robot.keyRelease(KeyEvent);
		Thread.sleep(100);
	}

	public static String getText(By locator, int timeOutInSeconds) throws Exception{
        WebDriver driver = DriverBase.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
    }

	/******************************************************************************************************************
	 * Select dropdown with a text
	 */
	public static void selectDropDownByText(By locator, String text){
		WebDriver driver = DriverBase.getDriver();
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByVisibleText(text);
	}

	/******************************************************************************************************************
	 * Select dropdown with a value
	 */
	public static void selectDropDownByValue(By locator, String value){
		WebDriver driver = DriverBase.getDriver();
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByValue(value);
	}

	/******************************************************************************************************************
	 * Drap and drop from an Locator to an Locator
	 */
	public static void drapAndDrop(By fromLocator, By toLocator){
		WebDriver driver = DriverBase.getDriver();
		WebElement fromElement = driver.findElement(fromLocator);
		WebElement toElement = driver.findElement(toLocator);
		Actions act = new Actions(driver);
		act.dragAndDrop(fromElement, toElement).build().perform();
	}

	/******************************************************************************************************************
	 * Drap and drop from an Element to an Element
	 */
	public static void drapAndDrop(WebElement fromElement, WebElement toElement){
		WebDriver driver = DriverBase.getDriver();
		Actions act = new Actions(driver);
		act.dragAndDrop(fromElement, toElement).build().perform();
	}

	/******************************************************************************************************************
	 * Drap and drop from an Element to specific cell
	 * NOTE: The pixels values change with screen resolution and browser size. This method is hence not reliable and not widely used.
	 */
	public static void drapAndDrop(By fromLocator, int xOffset, int yOffset ){
		WebDriver driver = DriverBase.getDriver();
		WebElement fromElement = driver.findElement(fromLocator);
		Actions act = new Actions(driver);
		act.dragAndDropBy(fromElement, xOffset, yOffset).build().perform();
	}

	/******************************************************************************************************************
	 * Select checkbox or radio button if they contain value attribute, otherwise using advance xpath
	 */
	public static void selectCheckBox(String value){
		WebDriver driver = DriverBase.getDriver();
		WebElement box = driver.findElement(By.xpath("//input[@value='" + value + "']"));
		if (!box.isSelected()){
			box.click();
		}
	}

	/******************************************************************************************************************
	 * De-select checkbox or radio button if they contain value attribute
	 */
	public static void DeselectCheckBox(String value){
		WebDriver driver = DriverBase.getDriver();
		WebElement box = driver.findElement(By.xpath("//input[@value='" + value + "']"));
		if (box.isSelected()){
			box.click();
		}
	}

	/******************************************************************************************************************
	 * Upload a file
	 */
	public static void uploadFile(By uploadButtonLocator, String fileLocation){
		WebDriver driver = DriverBase.getDriver();
		driver.findElement(uploadButtonLocator).sendKeys(fileLocation);
	}
}
