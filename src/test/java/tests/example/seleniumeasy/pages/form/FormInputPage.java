package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.selenium.WebUtils;

public class FormInputPage {
    private WebDriver driver;
    final Logger logger = LoggerFactory.getLogger(FormAjaxPage.class);

    // Constructor
    public FormInputPage(WebDriver driver){ this.driver = driver; }


    // Locator


    // Method
    public FormInputPage goInputForm() {
        driver.get("http://www.seleniumeasy.com/HelloController/input-form-demo.html");
        driver.manage().window().maximize();
        return this;
    }


    public FormInputPage enterTextTo(String texboxName, String withContent){
        By element = By.xpath("//*[text()='" + texboxName + "']/following-sibling::div/div/input");
        driver.findElement(element).sendKeys(withContent);
        return this;
    }

    public FormInputPage selectStateName(String stateName){
        driver.findElement(By.xpath("//option[text()='" + stateName + "']")).click();
        return this;
    }

    public FormInputPage clickRadioButtonName(String radioButtonName){
        driver.findElement(By.xpath("//input[@type='radio' and @value='" + radioButtonName + "']")).click();
        return this;
    }

    public FormInputPage enterDescription(String content){
        driver.findElement(By.xpath("//textarea")).sendKeys(content);
        return this;
    }

    public FormInputPage clickSend(){
        driver.findElement(By.xpath("//button[contains(text(), 'Send')]")).click();
        return this;
    }

    //Verify
    public FormInputPage verifyError(String texboxName, String expectedError){
        By errorIcon    = By.xpath("//*[text()='" + texboxName + "']/following-sibling::div/i");
        By errorMessage = By.xpath("//*[text()='" + texboxName + "']/following-sibling::div/small");

        String errorIconClass = WebUtils.findDynamicElement(errorIcon,3).getAttribute("class");
        String errorText      = WebUtils.findDynamicElement(errorMessage, 3).getText();

        logger.info(errorIconClass);
        logger.info(errorText);

        Assert.assertTrue(errorIconClass.contains("glyphicon-remove"));
        Assert.assertEquals("Please enter more than 2 characters", errorText);

        return this;
    }

}
