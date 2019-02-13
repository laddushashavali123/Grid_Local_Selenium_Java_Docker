package tests.example.seleniumeasy.specs.table;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.table.TablePaginationPage;

public class TablePaginationSpec extends DriverBase {
    @Test
    public void TablePaginationTest() throws InterruptedException {
        WebDriver driver = getDriver();
        TablePaginationPage tablePaginationPage = new TablePaginationPage(driver);

        tablePaginationPage.goToPaginationPage()
                .clickPaginationButton("3")
                .verifyButtonIsShown("«", "show")
                .verifyButtonIsShown("»", "hide")
                .verifyContentNumberDisplayIs(13)
                .clickPaginationButton("«")
                .verifyContentNumberDisplayIs(10)
                .verifyButtonIsShown("«", "show")
                .verifyButtonIsShown("»", "show")
                .clickPaginationButton("1")
                .verifyContentNumberDisplayIs(5)
                .verifyButtonIsShown("«", "hide")
                .verifyButtonIsShown("»", "show")
                .clickPaginationButton("»")
                .verifyContentNumberDisplayIs(10);
        Thread.sleep(2000);
    }
}
