package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.selenium.WebUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Scroll extends DriverBase{
    Logger logger = LoggerFactory.getLogger(DropDownandCheckBox.class);

    @Test
    public void test() throws InterruptedException, AWTException {
        WebDriver driver = getDriver();
        driver.get("https://fineuploader.com/demos");
        driver.manage().window().maximize();

        WebElement e=driver.findElement(By.xpath("//h3[text()='Validation']"));
        Coordinates cor=((Locatable)e).getCoordinates();
        cor.inViewPort();

        Thread.sleep(3000);
    }
}
