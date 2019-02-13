package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class FormAjaxPage {
    private WebDriver driver;
    final Logger logger = LoggerFactory.getLogger(FormAjaxPage.class);

    // Constructor
    public FormAjaxPage(WebDriver driver){ this.driver = driver; }


    // Locator


    // Method
    public FormAjaxPage goAjaxForm() {
        driver.get("http://www.seleniumeasy.com/HelloController/ajax-form-submit-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public FormAjaxPage enterTextTo(String texboxName, String withContent){
        By element = By.xpath("//*[contains(text(), 'Name')]/following-sibling::input");
        driver.findElement(element).sendKeys(withContent);
        return this;
    }

    public FormAjaxPage enterDiscription(String content){
        driver.findElement(By.xpath("//textarea")).sendKeys(content);
        return this;
    }

    public FormAjaxPage clickSend(){
        driver.findElement(By.id("btn-submit")).click();
        return this;
    }

    // Verify
    public FormAjaxPage verifyWatingMessage() throws InterruptedException {
        Thread.sleep(2000);
        String waitText = driver.findElement(By.id("submit-control")).getText();
        logger.info(waitText);
        Assert.assertEquals(waitText, "Form submited Successfully!");
        logger.info("Form submited Successfully! - TC passed");
        return this;
    }
}
