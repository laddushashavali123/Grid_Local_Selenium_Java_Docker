package tests.example.seleniumeasy.pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class TablePaginationPage {
    private WebDriver driver;
    final Logger logger = LoggerFactory.getLogger(TablePaginationPage.class);

    public TablePaginationPage(WebDriver driver){
        this.driver = driver;
    }

    // Method
    public TablePaginationPage goToPaginationPage() throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/HelloController/table-pagination-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public TablePaginationPage clickPaginationButton(String pageName) throws InterruptedException {
        By xpath = By.xpath("//*[@id= 'myPager']/li/a[contains(text(), '" + pageName + "')]");
        driver.findElement(xpath).click();
        Thread.sleep(500);
        return this;
    }

    // Assertion
    public TablePaginationPage verifyButtonIsShown(String buttonName, String status) throws InterruptedException {
        String style = driver.findElement(By.xpath("//*[@id= 'myPager']/li/a[contains(text(), '" + buttonName + "')]")).getAttribute("style");
        logger.info("Current style is " +style);
        if (status.equalsIgnoreCase("hide")){
            Assert.assertEquals(style, "display: none;");
            logger.info(buttonName + " button is hidden");
            Reporter.log(buttonName + " button is hidden");
        }
        else if (status.equalsIgnoreCase("show")){
            Assert.assertEquals(style, "display: block;");
            logger.info(buttonName + " button is shown");
            Reporter.log(buttonName + " button is shown");
        }

        return this;
    }

    public TablePaginationPage verifyContentNumberDisplayIs(int x){
        String expect = driver.findElement(By.xpath("//*[@id='myTable']/tr[@style='display: table-row;'][last()]/td")).getText();
        logger.info("Last number of table is " + expect);
        Assert.assertEquals(x, Integer.parseInt(expect));
        logger.info("Table shows correctly with " + expect + " rows");
        Reporter.log("Table shows correctly with " + expect + " rows");
        return this;
    }
}
