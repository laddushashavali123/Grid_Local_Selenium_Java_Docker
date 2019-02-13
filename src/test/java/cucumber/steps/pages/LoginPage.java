package cucumber.steps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPage {
    final private Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private WebDriver driver;
    private String pageURL = "http://demo.guru99.com/v4/index.php";

    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(name = "uid")      private WebElement username;
    @FindBy(name = "password") private WebElement password;
    @FindBy(name = "btnLogin") private WebElement submitButton;
    @FindBy(name = "btnReset") private WebElement resetButton;


    // Method
    public void nagivateToLoginPage() {
        driver.get(pageURL);
        driver.manage().window().fullscreen();
    }

    public void enterUsername(String content){
        username.sendKeys(content);
        logger.info("Entering username as " + content);
    }

    public void enterPassword(String content){
        password.sendKeys(content);
        logger.info("Entering password as " + content);
    }

    public void clickSubmit(){
        submitButton.click();
        logger.info("Click on Submit button");
    }

    // Assertion
    public void verifyLoginSuccess() throws InterruptedException {
        String newPageURL = driver.getCurrentUrl();
        Assert.assertEquals(newPageURL, "http://demo.guru99.com/v4/manager/Managerhomepage.php");
    }
}
