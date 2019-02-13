package tests.example.seleniumeasy.specs.table;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.table.TableFilterPage;

public class TableFilterSpec extends DriverBase{
    @Test
    public void TableFilterTest() throws InterruptedException {
        WebDriver driver= getDriver();
        TableFilterPage tableFilterPage = new TableFilterPage(driver);

        tableFilterPage.goTableFilterPage()
                .clickButtonName("Green")
                .verifyNumberContentIs(2)
                .clickButtonName("Orange")
                .verifyNumberContentIs(2)
                .clickButtonName("Red")
                .verifyNumberContentIs(1)
                .clickButtonName("All")
                .verifyNumberContentIs(5);
    }
}
