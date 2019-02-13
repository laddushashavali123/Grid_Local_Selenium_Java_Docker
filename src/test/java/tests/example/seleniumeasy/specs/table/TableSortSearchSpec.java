package tests.example.seleniumeasy.specs.table;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.table.TableSortSearchPage;

import java.util.Arrays;
import java.util.List;

public class TableSortSearchSpec extends DriverBase {
    @Test
    public void TableSortSearchTest() throws InterruptedException {
        WebDriver driver = getDriver();
        TableSortSearchPage tableSortSearchPage = new TableSortSearchPage(driver);

        tableSortSearchPage.goTableSortSearchPage()
                .verifyNumberOfTableIs(10)
                .selectShowEntries(25)
                .verifyNumberOfTableIs(25)
                .selectShowEntries(50)
                .verifyNumberOfTableIs(32)
                .selectShowEntries(100)
                .verifyNumberOfTableIs(32);

        List<String> expected = Arrays.asList("A. Satou","Accountant", "Tokyo", "33", "Fri 28th Nov 08", "$162,700/y");

        tableSortSearchPage.selectShowEntries(10)
                .sortBy("Position")
                .verifyColumnNameIsSortedAndRowIsCorrect("Position", "A. Satou", expected);

        Thread.sleep(7000);
    }
}
