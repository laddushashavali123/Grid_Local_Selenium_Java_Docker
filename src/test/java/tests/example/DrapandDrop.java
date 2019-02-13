package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.selenium.WebUtils;

import static utils.selenium.WebUtils.drapAndDrop;

public class DrapandDrop extends DriverBase {
    Logger logger = LoggerFactory.getLogger(DrapandDrop.class);
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("http://demo.guru99.com/HelloController/drag_drop.html");

        By plus5000      = By.xpath("//*[@id='fourth']/a");
        By saleIcon      = By.xpath("//*[@id='credit1']/a");
        By bankIcon      = By.xpath("//*[@id='credit2']/a");
        By accountDebit  = By.xpath("//*[@id='bank']/li");
        By amountDebit   = By.xpath("//*[@id='amt7']/li");
        By accountCrebit = By.xpath("//*[@id='loan']/li");
        By amountCrebit  = By.xpath("//*[@id='amt8']/li");
        By result        = By.xpath(("//*[@id='equal']/a"));

        drapAndDrop(bankIcon, accountDebit);
        drapAndDrop(plus5000, amountDebit);
        drapAndDrop(saleIcon, accountCrebit);
        drapAndDrop(plus5000, amountCrebit);

        logger.info(WebUtils.findDynamicElement(result,3).getText());
        Thread.sleep(3000);
    }
}
