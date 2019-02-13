package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class MouseHoverandTooltip extends DriverBase{
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.w3schools.com/howto/howto_css_tooltip.asp");

        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='tooltip']"));

        // Mouse hover
        Actions toolAct = new Actions(driver);
        toolAct.moveToElement(list.get(1)).build().perform();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.className("tooltip-right")).getText());
    }

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.w3schools.com/howto/howto_css_tooltip.asp");

        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='tooltip']"));
        System.out.println(list.size());
        list.get(0).click();

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.className("tooltip-top")).getText());
    }
}
