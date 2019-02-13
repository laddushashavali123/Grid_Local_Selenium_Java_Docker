package tests.example;

import base.DriverBase;
import utils.selenium.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Alert extends DriverBase {
    Logger loger = LoggerFactory.getLogger(Alert.class);
    /*@Test
    public void ConfirmationAlert() throws  Exception {
        WebDriver driver = getDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("//*[contains(@type,'submit')]")).click();
        // Dismiss the alert
        driver.switchTo().alert().dismiss();
        Thread.sleep(500);
        // Display content of the alert
        driver.findElement(By.xpath("//*[contains(@type,'submit')]")).click();
        loger.info(String.valueOf(driver.switchTo().alert().getText()));
        // Accept the alert
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    *//**
     * Authentication via Alert
     * @throws Exception
     */
    /*@Test
    public void AuthenticationAlert() throws  Exception   {
        WebDriver driver = getDriver();
        driver.get("https://kadung:123456789z@Z@portal.genband.com/");
        Thread.sleep(5000);
    }*/

    /**
     * Still not working ????

    @Test
    public void PromptAlert() throws  Exception{
        WebDriver driver = getDriver();
        driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[11]/button")).click();

        org.openqa.selenium.Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert .getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert .sendKeys("Accepting the alert");
        Thread.sleep(4000); //This sleep is not necessary, just for demonstration
        promptAlert .accept();
        Thread.sleep(3000);
    }*/

    /**
     * Alert with delay
     */
    @Test
    public void AlertDelay() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");
        driver.findElement(By.xpath("//*[@id=\"timingAlert\"]")).click();
        WebUtils.acceptAlert(8);
        Thread.sleep(2000);
    }
}
