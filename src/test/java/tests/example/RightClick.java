package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.selenium.WebUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RightClick extends DriverBase{
    @Test
    public void test() throws InterruptedException, AWTException {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com.vn");

        WebElement franceLang = driver.findElement(By.xpath("//a[text()='Français']"));

        Actions action = new Actions(driver);
        action.contextClick(franceLang).perform();

        WebUtils.pressKeyboard(KeyEvent.VK_DOWN);
        WebUtils.pressKeyboard(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }
}
