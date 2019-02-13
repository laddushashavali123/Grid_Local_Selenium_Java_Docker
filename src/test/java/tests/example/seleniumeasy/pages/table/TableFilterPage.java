package tests.example.seleniumeasy.pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class TableFilterPage {
    private WebDriver driver;
    final Logger logger = LoggerFactory.getLogger(TableFilterPage.class);

    public TableFilterPage(WebDriver driver){
        this.driver = driver;
    }

    // Method
    public TableFilterPage goTableFilterPage(){
        driver.get("http://www.seleniumeasy.com/HelloController/table-records-filter-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public TableFilterPage clickButtonName(String name) throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), '" + name + "')]")).click();
        Thread.sleep(300);
        return this;
    }

    // Assertion
    public TableFilterPage verifyNumberContentIs(int num){
        List<WebElement> totalElements = driver.findElements(By.xpath("//table[@class='table table-filter']/tbody/tr"));
        List<WebElement> hideElements = driver.findElements(By.xpath("//table[@class='table table-filter']/tbody/tr[@style='display: none;']"));
        logger.info("Total elements is " + totalElements.size());
        logger.info("Total hide elements is " + hideElements.size());
        int displayItems = totalElements.size() -hideElements.size();
        Assert.assertEquals(num, displayItems);
        logger.info("Result table display correctly with " + displayItems);
        Reporter.log("Result table display correctly with " + displayItems);
        return this;
    }
}
