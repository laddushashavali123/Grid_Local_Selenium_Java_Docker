/**
 * Ref: https://www.ontestautomation.com/findby-strategies-for-selenium-explained
 *
 * The find annotation is used in Page Objects in Selenium tests to specify the object location for a WebElement or a
 * list of WebElements. Using the PageFactory, these WebElements are usually initialized when a Page Object is created.
 * There are 3 annotations:
 *     + The @FindBy annotation is used to locate one or more WebElements using a single criterion, for example:
 *         - There is only a single element:
 *              @FindBy(how = How.ID, using = "elementid")
 *              private WebElement element;
 *         - There are more elements with same criterion:
 *              @FindBy(how = How.CLASS_NAME, using = "classname")
 *              private List<WebElement> singlecriterion;
 *     + The @FindBys annotation is used in case elements need to match all of the given criteria.
 *         @FindBys({
 *             @FindBy(how = How.NAME, using = "username"),
 *             @FindBy(how = How.NAME, using = "password")
 *         })
 *         private List<WebElement> bothcriteria;
 *     + The @FindAll annotation is used in case elements need to match at least one of the given criteria.
 *         @FindAll({
 *             @FindBy(how = How.NAME, using = "username"),
 *             @FindBy(how = How.NAME, using = "password")
 *         })
 *         private List<WebElement> eithercriterion;
 *
 */
package tests.page_object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Annotation_BankLogin {
    final private Logger logger = LoggerFactory.getLogger(Annotation_BankLogin.class);
    private WebDriver driver;
    private String pageURL = "http://demo.guru99.com/v4/index.php";


    public Annotation_BankLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(name = "uid")      private WebElement username;
    @FindBy(name = "password") private WebElement password;
    @FindBy(name = "btnLogin") private WebElement submitButton;
    @FindBy(name = "btnReset") private WebElement resetButton;


    // Method
    public Annotation_BankLogin nagivateToLoginPage(){
        driver.get(pageURL);
        driver.manage().window().fullscreen();
        return this;
    }

    public Annotation_BankLogin enterUsername(String content){
        username.sendKeys(content);
        logger.info("Entering username as " + content);
        return this;
    }

    public Annotation_BankLogin enterPassword(String content){
        password.sendKeys(content);
        logger.info("Entering password as " + content);
        return this;
    }

    public Annotation_BankLogin clickSubmit(){
        submitButton.click();
        logger.info("Click on Submit button");
        return this;
    }

    public Annotation_BankLogin clickReset(){
        resetButton.click();
        logger.info("Click on Reset button");
        return this;
    }

    // Assertion
    public void verifyLoginSuccess(){
        String newPageURL = driver.getCurrentUrl();
        Assert.assertEquals(newPageURL, "http://demo.guru99.com/v4/manager/Managerhomepage.php");
    }

}
