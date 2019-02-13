package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class RadioButtonPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(RadioButtonPage.class);

    // Constructor
    public RadioButtonPage(WebDriver driver){
        this.driver = driver;
    }


    // Locator
    By resultBox = By.className("groupradiobutton");


    // Action
    public RadioButtonPage goRadioButton() {
        driver.get("http://www.seleniumeasy.com/HelloController/basic-radiobutton-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public RadioButtonPage clickRadioButtonName(String buttonName){
        driver.findElement(By.xpath("//input[@value='" + buttonName + "']")).click();
        return this;
    }

    public RadioButtonPage clickRadioButtonNameGroup(String buttonName, String buttonGroup){
        driver.findElement(By.xpath("//input[@value='" + buttonName + "' and @name='" + buttonGroup + "']")).click();
        return this;
    }

    public RadioButtonPage clickButton(String buttonName){
        driver.findElement(By.xpath("//button[text()='" + buttonName + "']")).click();
        logger.info("Click button " + buttonName);
        return this;
    }


    // Assertion
    public void verifyResultTextIs(String expectedText){
        String actualText = driver.findElement(resultBox).getText().replace("\n", " and ");
        logger.info("Text in result box is " + actualText);
        Assert.assertEquals(actualText, expectedText);
        Reporter.log("Correct Text box");
    }
}
