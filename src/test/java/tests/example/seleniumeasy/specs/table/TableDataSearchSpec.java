package tests.example.seleniumeasy.specs.table;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.table.TableDataSearchPage;

public class TableDataSearchSpec extends DriverBase{
    @Test
    public void TableDataSearchTest(){
        WebDriver driver = getDriver();
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage(driver);

        tableDataSearchPage.goTableDataSearchPage()
                .entertaskInput("SEO tags")
                .verifyCorrectSearchItemName("SEO tags")
                .verifyTotalItemDisplayIs(1)
                .entertaskInput(" ")
                .verifyTotalItemDisplayIs(7)
                .entertaskInput("se")
                .verifyCorrectSearchItemName("SEO tags Browser Issues")
                .verifyTotalItemDisplayIs(2)
                .entertaskInput("aaaasd")
                .verifyTotalItemDisplayIs(0);
    }
}
