package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class DropDownSelectPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(DropDownSelectPage.class);

    // Constructor
    public DropDownSelectPage(WebDriver driver){
        this.driver = driver;
    }


    // Locator
    By selectListResult = By.className("selected-value");
    By multiSelectListResult = By.className("getall-selected");

    // Action
    public DropDownSelectPage goSelectDropDown() throws AWTException {
        driver.get("http://www.seleniumeasy.com/HelloController/basic-select-dropdown-demo.html");
        driver.manage().window().maximize();
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_PAGE_DOWN);
        rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
        return this;
    }


    public DropDownSelectPage dropDownSingleSelectByText(String dropDownBoxName, String optionName){
        Select dropDown = new Select(driver.findElement(By.xpath("//*[text()='" + dropDownBoxName + "']/following-sibling::div/select")));
        if (!dropDown.isMultiple()){
            dropDown.selectByVisibleText(optionName);
            logger.info(optionName + " is selected");
            return this;
        }

        try {
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_CONTROL);
            dropDown.selectByVisibleText(optionName);
            Thread.sleep(100);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            logger.info(optionName + " is selected");

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public DropDownSelectPage dropDownMultipleSelectContinous(String dropDownBoxName, int fromItem, int toItem ){
        List<WebElement> selectList = driver.findElements((By.xpath("//*[text()='" + dropDownBoxName + "']/following-sibling::div/select/option")));
        Actions action = new Actions(driver);
        action.clickAndHold(selectList.get(fromItem - 1)).moveToElement(selectList.get(toItem - 1)).release().build().perform();
        return this;
    }

    public DropDownSelectPage clickButtonName(String buttonName){
        driver.findElement(By.xpath("//button[text()='" + buttonName + "']")).click();
        logger.info("Click button " + buttonName);
        return this;
    }


    // Assertion
    public void verifySelectListResultIs(String expectedString){
        String actualText = driver.findElement(selectListResult).getText();
        logger.info("Text box result is " + actualText);
        Assert.assertEquals("Day selected :- " + expectedString, actualText);
        Reporter.log("Passed baby, Passed Passed");
        logger.info("Select list is correct");
        logger.info("-----------------------");
    }

    // ------------------------------------------------------------------------------
    // If no love with Selenium Action API
    public DropDownSelectPage selectOption(String optionName){
        try{
            driver.findElement(By.xpath("//option[@value='" + optionName + "']")).click();
            logger.info(optionName + " is selected");
        }
        catch (Exception e){
            driver.findElement(By.xpath("//option[text()='" + optionName + "']")).click();
            logger.info(optionName + " is selected");
        }
        return  this;
    }




}
