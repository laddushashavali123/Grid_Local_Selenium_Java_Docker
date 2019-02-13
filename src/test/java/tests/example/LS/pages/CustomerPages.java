package tests.example.LS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CustomerPages {
    private final Logger logger = LoggerFactory.getLogger(CustomerPages.class);
    private WebDriver driver;
    private String pageUrl = "https://kvs1-ls-portal.kandy.io/va/ffd4d37b-5248-494f-b07a-19da5ca1f754";
    private int waitTime = 1;
    private List<String> tabPosition = new ArrayList<>();

    public CustomerPages(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    // Locator


    // Method
    public CustomerPages accessCustomerPage(){
        driver.get(pageUrl);
        logger.info("Access Customer page: " + pageUrl);
        return this;
    }

    public CustomerPages clickOnText(String s){
        driver.findElement(By.xpath("//button[contains(text(),'" + s + "')]")).click();
        logger.info("Click on link " + s);
        return this;
    }

    public CustomerPages enterTextTo(String textBoxName, String content){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@placeholder, '" + textBoxName + "')]")));
        element.clear();
        element.sendKeys(content);
        element.sendKeys(Keys.ENTER);
        logger.info("Enter '" + content + "' to textbox " + textBoxName);
        return this;
    }

    public CustomerPages clickStartBotChat(){
        driver.findElement(By.xpath("//button[contains(text(), 'Start Bot Chat')]")).click();
        logger.info("Click on Start Bot Chat button");
        return this;
    }

    public CustomerPages openAgentTab(){
        tabPosition.add(driver.getWindowHandle());
        logger.info("First tab ID is " + tabPosition.get(0));

        openNewTab();

        tabPosition.add(returnNewTabID(tabPosition, driver.getWindowHandles()));
        logger.info("Second tab ID is " + tabPosition.get(1));

        switchToTab(2);
        return this;
    }

    public void switchToTab(int i){
        driver.switchTo().window(tabPosition.get(i-1));
    }


    // Assertion
    public CustomerPages verifyBotRespond() throws InterruptedException {
        Thread.sleep(20000);
        logger.info(driver.findElement(By.xpath("//*[contains(text(),'Hello how can i help you ?')]")).getText());
        logger.info(driver.findElement(By.className("bot-chat-box")).getText());
        return this;
    }


    // Addon
    private void openNewTab(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            Thread.sleep(3000);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String returnNewTabID(List<String> tabIDs, Set<String> allID){
        List<String> temp = new ArrayList<>();
        temp.addAll(allID);

        for(String i : tabIDs){
            for (String j : temp){
                if (i.equalsIgnoreCase(j)){
                    temp.remove(i);
                    break;
                }
            }
        }
        return temp.get(0);
    }

}
