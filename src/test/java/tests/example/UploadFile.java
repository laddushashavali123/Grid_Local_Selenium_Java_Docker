package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.selenium.WebUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UploadFile extends DriverBase{
    Logger logger = LoggerFactory.getLogger(DropDownandCheckBox.class);

    @Test
    public void test() throws InterruptedException, AWTException {
        WebDriver driver = getDriver();
        driver.get("https://fineuploader.com/demos");
        driver.manage().window().maximize();

        By uploadButton = By.xpath("//input[@title='file input']");
        By imageText    = By.xpath("//*[@class=\"qq-file-name\"]/span");

        WebUtils.uploadFile(uploadButton, "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
        Thread.sleep(500);

        WebUtils.pressKeyboard(KeyEvent.VK_PAGE_DOWN);

        logger.info(driver.findElement(imageText).getText());
        Thread.sleep(3000);
    }
}
