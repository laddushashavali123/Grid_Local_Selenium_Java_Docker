package tests.example.seleniumeasy.specs.table;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.table.TableDataDownloadPage;

public class TableDataDownloadSpec extends DriverBase{
    @Test
    public void TableDataDownloadTest() throws InterruptedException {
        WebDriver driver = getDriver();
        TableDataDownloadPage tableDataDownloadPage = new TableDataDownloadPage(driver);

        tableDataDownloadPage.goTableDataDownloadPage()
                .clickDownloadFile("CSV")
                .verifyFileDownloaded("C:\\Users\\MyPC\\Downloads",
                    "Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.csv",
                    5)
                .verifyCSVHasCorrectItemsQuatities("C:\\Users\\MyPC\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.csv", 31);
    }
}
