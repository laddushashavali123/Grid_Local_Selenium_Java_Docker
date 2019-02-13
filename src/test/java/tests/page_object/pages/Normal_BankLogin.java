/**
 * https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html
 */
package tests.page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Normal_BankLogin {
    final private Logger logger = LoggerFactory.getLogger(Normal_BankLogin.class);
    private WebDriver driver;
    String pageURL = "http://demo.guru99.com/v4/index.php";

    public Normal_BankLogin(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    By username     = By.name("uid");
    By password     = By.name("password");
    By submitButton = By.name("btnLogin");
    By resetButton  = By.name("btnReset");

    // Method
    public Normal_BankLogin openLoginPage(){
        driver.get(pageURL);
        return this;
    }

    public Normal_BankLogin enterUsername(String content){
        driver.findElement(username).sendKeys(content);
        logger.info("Entering username as " + content);
        return this;
    }

    public Normal_BankLogin enterPassword(String content){
        driver.findElement(password).sendKeys(content);
        logger.info("Entering password as " + content);
        return this;
    }

    public Normal_BankLogin clickSubmit(){
        driver.findElement(submitButton).click();
        logger.info("Click on Submit button");
        return this;
    }

    public Normal_BankLogin clickReset(){
        driver.findElement(resetButton).click();
        logger.info("Click on Reset button");
        return this;
    }

    // Assertion
    public void verifyLoginSuccess(){
        String newPageURL = driver.getCurrentUrl();
        Assert.assertEquals(newPageURL, "http://demo.guru99.com/v4/manager/Managerhomepage.php");
    }

}
