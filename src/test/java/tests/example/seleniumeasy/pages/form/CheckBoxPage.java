package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(CheckBoxPage.class);

    // Constructor
    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
    }


    // Locator
    private By checkBoxMessage = By.id("txtAge");
    private By checkAllbutton  = By.id("check1");


    // Action
    public CheckBoxPage goCheckBox() {
        driver.get("http://www.seleniumeasy.com/HelloController/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public CheckBoxPage clickCheckBoxName(String checkBoxName){
        driver.findElement(By.xpath("//*[text()='" + checkBoxName + "']/input")).click();
        logger.info(checkBoxName + " checkbox is checked");
        return this;
    }

    public CheckBoxPage clickInputButton(String buttonName){
        driver.findElement(By.xpath("//input[@value='" + buttonName + "']")).click();
        logger.info("Click button " + buttonName);
        return this;
    }


    // Assertion
    public CheckBoxPage verifyCheckBoxMessageIs(String expectedMessage){
        String actualText = driver.findElement(checkBoxMessage).getText();
        logger.info("Actual message from checkbox is: \"" + actualText + "\"");
        Assert.assertEquals(actualText, expectedMessage);
        Reporter.log("Checkbox message display correctly.");
        return this;
    }



    public CheckBoxPage verifyAllCheckBoxIs(String status){
        List<WebElement> elements = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        if (status.equalsIgnoreCase("Checked")){
            for (WebElement e : elements){
                Assert.assertTrue(e.isSelected());
            }
            logger.info("All checkboxes are checked");
        }
        else {
            for (WebElement e : elements){
                Assert.assertFalse(e.isSelected());
            }
            logger.info("All checkboxes are unchecked");
        }
        return this;
    }

    public CheckBoxPage verifyInputButtonTextIs(String expectedText){
        String buttonText = driver.findElement(checkAllbutton).getAttribute("value");
        logger.info("Button text is: " + "\"" + buttonText + "\"");
        Assert.assertEquals(buttonText, expectedText);
        return this;
    }
}
