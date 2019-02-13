package tests.example.seleniumeasy.pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableSortSearchPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(TableSortSearchPage.class);

    public TableSortSearchPage(WebDriver driver){
        this.driver = driver;
    }

    // Action
    public TableSortSearchPage goTableSortSearchPage(){
        driver.get("http://www.seleniumeasy.com/HelloController/table-sort-search-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public TableSortSearchPage selectShowEntries(int value){
        driver.findElement(By.xpath("//option[@value='" + Integer.toString(value) + "']")).click();
        return this;
    }

    public TableSortSearchPage sortBy(String value) throws InterruptedException {
        WebElement item = driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[contains(text(), '" + value + "')]"));
        logger.info("Current table is sorted by " + value + " as " + item.getAttribute("aria-sort"));
        item.click();
        Thread.sleep(200);
        logger.info("Table is changed to sort by " + value + " as " + item.getAttribute("aria-sort"));
        return this;
    }


    // Assertion
    public TableSortSearchPage verifyNumberOfTableIs(int expectedNumber){
        int totalElements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
        logger.info("Total shown items are " + Integer.toString(totalElements));
        Assert.assertEquals(expectedNumber, totalElements);
        logger.info("Table displays correctly with " + totalElements + " items");
        Reporter.log("Table displays correctly with " + totalElements + " items");
        return this;
    }

    public void verifyColumnNameIsSortedAndRowIsCorrect(String columnName, String name, List<String> expectedResult) {
        // Verify row data after sorted
        List<String> rowData = new ArrayList<>();
        List<WebElement> currentRowElements = driver.findElements(By.xpath("//td[text()='" + name + "']/../td"));
        logger.info("Current Row with " + name + " data are: ");
        for (WebElement e : currentRowElements){
            rowData.add(e.getText());
            logger.info(e.getText());
        }
        logger.info("---");
        Assert.assertEquals(expectedResult, rowData);
        logger.info("Row is changed correctly after sorting");

        // Verify column is sorted correctly
        List<String> columnData = new ArrayList<>();
        By columnXpath;
        switch (columnName){
            case "Name":
                columnXpath = By.xpath("//table[@id='example']/tbody/tr/td[1]");
                break;
            case "Position":
                columnXpath = By.xpath("//table[@id='example']/tbody/tr/td[2]");
                break;
            case  "Office":
                columnXpath = By.xpath("//table[@id='example']/tbody/tr/td[3]");
                break;
            case "Age":
                columnXpath = By.xpath("//table[@id='example']/tbody/tr/td[4]");
                break;
            case "Start date":
                columnXpath = By.xpath("//table[@id='example']/tbody/tr/td[5]");
                break;
            case "Salary":
                columnXpath = By.xpath("//table[@id='example']/tbody/tr/td[6]");
                break;
            default:
                logger.info("Buddy choose incorrectly");
                throw new IndexOutOfBoundsException();
        }
        List<WebElement> columnElements = driver.findElements(columnXpath);
        logger.info("Current Column with " + columnName + " data are: ");
        for (WebElement e : columnElements){
            columnData.add(e.getText());
            logger.info(e.getText());
        }
        logger.info("---");
        Assert.assertTrue(columnData.stream().sorted().collect(Collectors.toList()).equals(columnData));
        logger.info("Column is sorted");
    }

}
