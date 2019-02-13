package tests.example.demoqa.testcase;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.demoqa.pages.SortablePage;

public class SortableSpec extends DriverBase{
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = getDriver();
        SortablePage sortablePage = new SortablePage(driver);

        sortablePage.accessPage();
        sortablePage.moveElement("Item 1", "Item 5");
        sortablePage.checkLocation();
        Thread.sleep(2000);
    }
}
