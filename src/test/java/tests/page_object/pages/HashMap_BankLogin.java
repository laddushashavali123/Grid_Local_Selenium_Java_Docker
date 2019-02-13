/**
 * https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html
 */
package tests.page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.HashMap;

public class HashMap_BankLogin {
    final private Logger logger = LoggerFactory.getLogger(HashMap_BankLogin.class);
    private WebDriver driver;
    private HashMap<String, By> elements = new HashMap<>();
    String pageURL = "http://demo.guru99.com/v4/index.php";

    public HashMap_BankLogin(WebDriver driver){
        this.driver = driver;
        driver.manage().window().fullscreen();
        driver.get(pageURL);

        // Locator
        elements.put("username", By.name("uid"));
        elements.put("password", By.name("password"));
        elements.put("submitButton", By.name("btnLogin"));
        elements.put("resetButton", By.name("btnReset"));
    }


    // Method
    public HashMap_BankLogin enter(String textboxName, String content){
        driver.findElement(elements.get(textboxName)).sendKeys(content);
        logger.info("Entering " + textboxName + " as " + content);
        return this;
    }

    public HashMap_BankLogin click(String buttonName){
        driver.findElement(elements.get(buttonName)).click();
        logger.info("Click on " + buttonName + " button");
        return this;
    }


    // Assertion
    public void verifyLoginSuccess(){
        String newPageURL = driver.getCurrentUrl();
        Assert.assertEquals(newPageURL, "http://demo.guru99.com/v4/manager/Managerhomepage.php");
    }

}
