package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class FormSimplePage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(FormSimplePage.class);

    // Constructor
    public FormSimplePage(WebDriver driver){
        this.driver = driver;
    }


    // Locator
    private By resultTextBox = By.id("display");
    private By totalTextBox  = By.id("displayvalue");


    // Action
    public FormSimplePage goSimpleForm() {
        driver.get("http://www.seleniumeasy.com/HelloController/basic-first-form-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public FormSimplePage enterTextToTextBox(String textboxName, String contents){
        driver.findElement(By.xpath("//*[text()='" + textboxName + "']/following-sibling::input")).sendKeys(contents);
        logger.info("Enter " + contents + " to textbox " + textboxName);
        return this;
    }

    public FormSimplePage clickButtonName(String buttonName){
        driver.findElement(By.xpath("//button[text()='" + buttonName + "']")).click();
        logger.info("Click button " + buttonName);
        return this;
    }


    // Assertion
    public void verifyResultTextIs(String expectedText){
        String actualText = driver.findElement(resultTextBox).getText();
        logger.info("Result text is: " + actualText);
        Assert.assertEquals(actualText,expectedText);
        Reporter.log("Single Input Field is PASSED");
    }

    public void verifyTotalTextIs(String expectedText){
        String actualText = driver.findElement(totalTextBox).getText();
        logger.info("Result text is: " + actualText);
        Assert.assertEquals(actualText,expectedText);
        Reporter.log("Two Input Fields is PASSED");
    }


    /*public boolean verifyText(String textboxName, String expectedText){
        String actualText = driver.findElement(By.xpath("//*[text()='" + textboxName + "']/following-sibling::span")).getText();
        logger.info("Actual your message is: " + actualText);
        if (expectedText.equals(actualText)){
            return true;
        }
        return false;
    }*/
}
