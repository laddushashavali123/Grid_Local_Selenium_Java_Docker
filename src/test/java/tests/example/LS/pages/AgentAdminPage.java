package tests.example.LS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AgentAdminPage {
    Logger logger = LoggerFactory.getLogger(CustomerPages.class);
    private WebDriver driver;
    private String pageUrl = "https://kvs1-ls-agent.kandy.io/mo5LRZ1X/login ";
    private String username = "test555";
    private String password = "Kandy-1234";
    private int waitTime = 1;

    public AgentAdminPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    // Locator
    By userTextBox = By.xpath("//input[contains(@placeholder, 'Username')]");
    By passTextBox = By.xpath("//input[contains(@placeholder, 'Password')]");
    By loginButton = By.xpath("//input[contains(@value, 'login')]");


    // Method
    public AgentAdminPage loginAgentAdminPage() {
        driver.get(pageUrl);
        driver.findElement(userTextBox).sendKeys(username);
        driver.findElement(passTextBox).sendKeys(password);
        driver.findElement(loginButton).submit();
        logger.info("Access Agent Admin page: " + pageUrl);
        return this;
    }

    public AgentAdminPage sideBarClickOn(String sidebarName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + sidebarName + "')]")));
        executor.executeScript("arguments[0].click()", element);

        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + sidebarName + "')]/following-sibling::div/div/div[last()]")));
        executor.executeScript("arguments[0].click()", element1);

        return this;
    }


    // Assertion
    public AgentAdminPage getMonitorMessage() throws InterruptedException {
        Thread.sleep(20000);
        logger.info(driver.findElement(By.xpath("//*[contains(text(),'Hello how can i help you ?')]")).getText());
        logger.info(driver.findElement(By.className("bot-chat-box")).getText());
        return this;
    }

}
