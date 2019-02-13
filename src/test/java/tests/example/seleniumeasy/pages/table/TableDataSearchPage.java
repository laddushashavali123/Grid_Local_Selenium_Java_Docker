package tests.example.seleniumeasy.pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class TableDataSearchPage {
    private WebDriver driver;
    final Logger logger = LoggerFactory.getLogger(TableDataSearchPage.class);

    public  TableDataSearchPage(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    By taskInput              = By.xpath("//*[@id= 'task-table-filter']");
    By FilterButtonListedUser = By.xpath("//button[contains(text(), 'Filter')]");


    // Method
    public TableDataSearchPage goTableDataSearchPage(){
        driver.get("http://www.seleniumeasy.com/HelloController/table-search-filter-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public TableDataSearchPage entertaskInput(String text){
        driver.findElement(taskInput).clear();
        driver.findElement(taskInput).sendKeys(text);
        return this;
    }



    // Assertion
    public TableDataSearchPage verifyTotalItemDisplayIs(int x){
        try {
            String errorMessage = driver.findElement(By.xpath("//*[@id= 'task-table']/tbody/tr[@class='filterTable_no_results']")).getText();
            logger.info("Error message is " + errorMessage);
            Assert.assertEquals(errorMessage, "No results found");
            logger.info("No results found");
            Reporter.log("No results found");
            return this;
        }
        catch (Exception e) {
            List<WebElement> resultElements = driver.findElements(By.xpath("//*[@id= 'task-table']/tbody/tr[not(@style='display: none;')]"));
            logger.info("Total result query row is " + resultElements.size());
            Assert.assertEquals(x, resultElements.size());
            logger.info("Result table displays correctly with " + x + " item");
            Reporter.log("Result table displays correctly with " + x + " item");
            return this;
        }
    }

    public TableDataSearchPage verifyCorrectSearchItemName(String expectedItemName){
        String result = "";
        List<WebElement> resultElements = driver.findElements(By.xpath("//*[@id= 'task-table']/tbody/tr[not(@style='display: none;')]/td[2]"));
        for (WebElement e : resultElements){
            result += e.getText() + " ";
        }
        logger.info(" Names are " + result);
        Assert.assertEquals(result.trim(), expectedItemName);
        return this;
    }
}
